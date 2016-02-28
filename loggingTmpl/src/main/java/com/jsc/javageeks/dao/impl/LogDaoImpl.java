
package com.jsc.javageeks.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.jsc.javageeks.dao.LogDao;
import com.jsc.javageeks.model.ApiLogEntry;
import com.jsc.javageeks.utils.DatabaseUtils;

@Repository("logDao")
public class LogDaoImpl implements LogDao {

	public int apiLogging(ApiLogEntry apiLogEntry) {

		Connection con = null;
		PreparedStatement preparedStatement = null;
		int rowEffected = 0;
		try {
			// 1. getting connection from DatabaseUtils
			con = DatabaseUtils.createConnection();

			// 2. read query from sql.properties file.
			String query = "INSERT INTO API_LOGGING (id, USER, machine, request_ip_address, request_content_type, request_content_body, request_uri, request_method, request_headers, request_timestamp, response_content_type, response_content_body, response_status_code, response_headers, response_timestamp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

			// 3. preparing and setting parameters of preparedStatement
			preparedStatement = con.prepareStatement(query);

			// 4. setting the values from apiLogEntry
			preparedStatement.setInt(1, apiLogEntry.getId());
			preparedStatement.setString(2, apiLogEntry.getUser());
			preparedStatement.setString(3, apiLogEntry.getMachine());
			preparedStatement.setString(4, apiLogEntry.getRequestIpAddress());
			preparedStatement.setString(5, apiLogEntry.getRequestContentType());
			preparedStatement.setString(6, apiLogEntry.getRequestContentBody());
			preparedStatement.setString(7, apiLogEntry.getRequestUri());
			preparedStatement.setString(8, apiLogEntry.getRequestMethod());
			preparedStatement.setString(9, apiLogEntry.getRequestHeaders());
			preparedStatement.setDate(10, apiLogEntry.getRequestTimestamp());
			preparedStatement.setString(11, apiLogEntry.getResponseContentType());
			preparedStatement.setString(12, apiLogEntry.getResponseContentBody());
			preparedStatement.setInt(13, apiLogEntry.getResponseStatusCode());
			preparedStatement.setString(14, apiLogEntry.getResponseHeaders());
			preparedStatement.setDate(15, apiLogEntry.getResponseTimestamp());

			rowEffected = DatabaseUtils.runQueryOnPrepareStatement(preparedStatement);

		} catch (SQLException exception) {
			System.out.println("exception :" + exception.getMessage());
		} finally {
			DatabaseUtils.closeStatement(preparedStatement);
			DatabaseUtils.closeConnection(con);
		}

		return rowEffected;
	}
}
