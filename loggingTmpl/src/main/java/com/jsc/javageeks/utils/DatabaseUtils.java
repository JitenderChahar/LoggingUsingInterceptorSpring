/**********************************************************************************************
 * @author Jitender Chahar
 * 
 * 1) Utility class for database
 * 2) creation and closing JDBC connection 
 * 3) contains utility methods to perform various database operations.
 *
 **********************************************************************************************/
package com.jsc.javageeks.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public final class DatabaseUtils {

	/**
	 * Creating logger for the class
	 */
	private static final Logger logger = Logger.getLogger(DatabaseUtils.class);

	public static Properties properties = new Properties();
	public static InputStream inputStream = null;

	public static Connection connection;
	public static String driver;
	public static String connectionURL;
	public static String user;
	public static String password;

	/**
	 * private constructor reading the properties of driver, connectionURL,
	 * user, password from property file config.properties
	 * 
	 */
	public DatabaseUtils() {
		logger.info("inside DatabaseUtils constructor");
		try {
			inputStream = getClass().getResourceAsStream("/config.properties");
			// 1. load a properties file
			properties.load(inputStream);

			// 2. get the property value
			driver = properties.getProperty("driver");
			connectionURL = properties.getProperty("connectionURL");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException ioException) {
			logger.error(ioException.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ioException) {
					logger.error(ioException.getMessage());
				}
			}
		}
	}

	/**
	 * Method to return the connection
	 * 
	 * @return Connection
	 */
	public static Connection createConnection() {
		try {
			// 1. Loading the driver
			Class.forName(driver);
			// 2. Creating a connection
			connection = DriverManager.getConnection(connectionURL, user,
					password);
		} catch (ClassNotFoundException exception) {
			logger.error("Driver not found");
		} catch (SQLException exception) {
			logger.error("Connection exception" + exception.getMessage());
		}

		return connection;
	}

	/**
	 * Method to close the connection
	 * 
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException exception) {
				logger.error(exception.getMessage());
			}
		}
	}

	/**
	 * Method to close the PreparedStatement
	 * 
	 * @param preparedStatement
	 */
	public static void closeStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException exception) {
				logger.error(exception.getMessage());
			}
		}
	}

	/**
	 * Method to get a result set of a query
	 * 
	 * @param connection
	 *            connection object
	 * @param query
	 *            custom query
	 * @return a result set of custom query
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static ResultSet getResultSet(Connection connection, String query)
			throws SQLException {
		ResultSet rs;
		PreparedStatement st = connection.prepareStatement(query);
		rs = st.executeQuery();
		return rs;
	}

	/**
	 * Method to get a result set of a query
	 * 
	 * 
	 * @param PreparedStatement
	 *            st
	 * @return a result set of custom query
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static ResultSet getResultSetOnPreaparedQuery(
			PreparedStatement preparedStatement) throws SQLException {
		ResultSet resultSet;
		resultSet = preparedStatement.executeQuery();
		return resultSet;
	}

	/**
	 * Method to run an update query such as update, delete
	 * 
	 * @param query
	 *            custom query
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static int runQuery(Connection con, String query)
			throws SQLException {
		PreparedStatement st = con.prepareStatement(query);
		return st.executeUpdate();
	}

	/**
	 * Method to run an update query such as update, delete using
	 * PrepareStatement
	 * 
	 * @param PreparedStatement
	 *            preparedStatement
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 */
	public static int runQueryOnPrepareStatement(
			PreparedStatement preparedStatement) throws SQLException {
		return preparedStatement.executeUpdate();
	}
}