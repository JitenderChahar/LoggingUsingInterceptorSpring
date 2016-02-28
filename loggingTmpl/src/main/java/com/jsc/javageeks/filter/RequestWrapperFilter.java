/****************************************************************
 * @author GS-0957 - Jitender Chahar
 * 
 * 1) Filter Class.
 *
 ****************************************************************/

package com.jsc.javageeks.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class RequestWrapperFilter implements Filter {

	/**
	 * Creating logger for the class
	 * 
	 */
	private static final Logger logger = Logger.getLogger(RequestWrapperFilter.class);

	/**
	 * overridden method.
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Inside doFilter() of RequestWrapperFilter");

		MultiReadHttpServletRequest requestWrapper = new MultiReadHttpServletRequest((HttpServletRequest) request);

		/*
		 * BufferedHttpResponseWrapper responseWrapper = new
		 * BufferedHttpResponseWrapper( (HttpServletResponse) response);
		 */

		logger.info("Exiting doFilter() of RequestWrapperFilter");
		chain.doFilter(requestWrapper, response);
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}