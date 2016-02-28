/*************************************************************************
 * @author GS-0957 - Jitender Chahar
 * 
 * Utility Class having commonly used methods used application wide.
 *
 *************************************************************************/

package com.jsc.javageeks.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

import org.apache.log4j.Logger;
public class Utils {
	private static final Logger logger = Logger.getLogger(Utils.class);

	/**
	 * Method to convert inputStream to String
	 * 
	 * @param inputStream
	 * @return
	 */
	public static String getStringFromInputStream(InputStream inputStream) {

		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();
		String line;

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream));
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * Method convert Enumeration<String> to header names
	 * 
	 * @param headerNames
	 * @return
	 */
	public static String getHeaderNames(Enumeration<String> headerNames) {
		StringBuilder stringBuilder = new StringBuilder();
		if (headerNames == null)
			return null;

		while (headerNames.hasMoreElements()) {
			stringBuilder.append(headerNames.nextElement());
			stringBuilder.append(", ");
		}

		String headers = stringBuilder.toString();
		return headers.substring(0, headers.length() - 2);
	}
}
