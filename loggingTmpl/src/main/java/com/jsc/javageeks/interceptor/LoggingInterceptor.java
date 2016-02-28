
package com.jsc.javageeks.interceptor;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jsc.javageeks.dao.LogDao;
import com.jsc.javageeks.dao.impl.LogDaoImpl;
import com.jsc.javageeks.model.ApiLogEntry;
import com.jsc.javageeks.utils.Utils;

public class LoggingInterceptor extends HandlerInterceptorAdapter {

	/**
	 * Creating logger for the class
	 * 
	 */
	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class);

	/**
	 * overridden method to log request to database
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * logger.info("Inside preHandle() of LoggingInterceptor");
		 * 
		 * MedicareDAO medicareDAO; ApiLogEntry apiLogEntry = new ApiLogEntry();
		 * apiLogEntry.setUser(request.getRemoteUser());
		 * apiLogEntry.setMachine(request.getRemoteHost());
		 * apiLogEntry.setRequestIpAddress(request.getRemoteAddr());
		 * apiLogEntry.setRequestContentType(request.getContentType());
		 * apiLogEntry.setRequestContentBody(Utils
		 * .getStringFromInputStream(request.getInputStream()));
		 * apiLogEntry.setRequestUri(request.getRequestURI());
		 * apiLogEntry.setRequestMethod(request.getMethod());
		 * apiLogEntry.setRequestHeaders(Utils.getHeaderNames(request
		 * .getHeaderNames())); apiLogEntry.setRequestTimestamp(new
		 * Date(Calendar.getInstance() .getTime().getTime())); try { medicareDAO
		 * = new MedicareDAOImpl(); int rowEffected =
		 * medicareDAO.apiLogging(apiLogEntry); logger.info("rowEffected : " +
		 * rowEffected); } catch (Exception exception) {
		 * logger.error(exception.getMessage()); }
		 * 
		 * logger.info("Exiting preHandle() of LoggingInterceptor");
		 */
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("Inside afterCompletion() of LoggingInterceptor");

		LogDao logDao;
		ApiLogEntry apiLogEntry = new ApiLogEntry();

		// 1. setting request
		apiLogEntry.setUser(request.getRemoteUser());
		apiLogEntry.setMachine(request.getRemoteHost());
		apiLogEntry.setRequestIpAddress(request.getRemoteAddr());
		apiLogEntry.setRequestContentType(request.getContentType());
		apiLogEntry.setRequestContentBody(Utils.getStringFromInputStream(request.getInputStream()));
		apiLogEntry.setRequestUri(request.getRequestURI());
		apiLogEntry.setRequestMethod(request.getMethod());
		apiLogEntry.setRequestHeaders(Utils.getHeaderNames(request.getHeaderNames()));
		apiLogEntry.setRequestTimestamp(new Date(Calendar.getInstance().getTime().getTime()));

		// 2. setting response
		apiLogEntry.setResponseContentType(response.getContentType());
		apiLogEntry.setResponseStatusCode(response.getStatus());
		apiLogEntry.setResponseTimestamp(new Date(Calendar.getInstance().getTime().getTime()));

		apiLogEntry.setResponseContentBody(response.getOutputStream().toString());
		apiLogEntry.setResponseHeaders(response.getHeaderNames().toString());

		try {
			// 3. log the api request and response
			logDao = new LogDaoImpl();
			int rowEffected = logDao.apiLogging(apiLogEntry);
			logger.info("rowEffected : " + rowEffected);
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}

		logger.info("Exiting afterCompletion() of LoggingInterceptor");
	}

}
