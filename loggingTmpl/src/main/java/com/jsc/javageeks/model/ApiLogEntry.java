package com.jsc.javageeks.model;

import java.sql.Date;

public class ApiLogEntry {
	// The (database) ID for the API log entry.
	private int id;
	// The user that made the request.
	private String user;
	// The machine that made the request.
	private String machine;
	// The IP address that made the request.
	private String requestIpAddress;
	// The request content type.
	private String requestContentType;
	// The request content body.
	private String requestContentBody;
	// The request URI.
	private String requestUri;
	// The request method (GET, POST, etc).
	private String requestMethod;
	// The request headers.
	private String requestHeaders;
	// The request timestamp.
	private Date requestTimestamp;
	// The response content type.
	private String responseContentType;
	// The response content body.
	private String responseContentBody;
	// The response status code.
	private int responseStatusCode;
	// The response headers.
	private String responseHeaders;
	// The response timestamp.
	private Date responseTimestamp;

	public ApiLogEntry() {
	}

	public ApiLogEntry(int id, String user, String machine,
			String requestIpAddress, String requestContentType,
			String requestContentBody, String requestUri, String requestMethod,
			String requestHeaders, Date requestTimestamp,
			String responseContentType, String responseContentBody,
			int responseStatusCode, String responseHeaders,
			Date responseTimestamp) {
		this.id = id;
		this.user = user;
		this.machine = machine;
		this.requestIpAddress = requestIpAddress;
		this.requestContentType = requestContentType;
		this.requestContentBody = requestContentBody;
		this.requestUri = requestUri;
		this.requestMethod = requestMethod;
		this.requestHeaders = requestHeaders;
		this.requestTimestamp = requestTimestamp;
		this.responseContentType = responseContentType;
		this.responseContentBody = responseContentBody;
		this.responseStatusCode = responseStatusCode;
		this.responseHeaders = responseHeaders;
		this.responseTimestamp = responseTimestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getRequestIpAddress() {
		return requestIpAddress;
	}

	public void setRequestIpAddress(String requestIpAddress) {
		this.requestIpAddress = requestIpAddress;
	}

	public String getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(String requestContentType) {
		this.requestContentType = requestContentType;
	}

	public String getRequestContentBody() {
		return requestContentBody;
	}

	public void setRequestContentBody(String requestContentBody) {
		this.requestContentBody = requestContentBody;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(String requestHeaders) {
		this.requestHeaders = requestHeaders;
	}

	public Date getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public String getResponseContentType() {
		return responseContentType;
	}

	public void setResponseContentType(String responseContentType) {
		this.responseContentType = responseContentType;
	}

	public String getResponseContentBody() {
		return responseContentBody;
	}

	public void setResponseContentBody(String responseContentBody) {
		this.responseContentBody = responseContentBody;
	}

	public int getResponseStatusCode() {
		return responseStatusCode;
	}

	public void setResponseStatusCode(int responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

	public String getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders(String responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public Date getResponseTimestamp() {
		return responseTimestamp;
	}

	public void setResponseTimestamp(Date responseTimestamp) {
		this.responseTimestamp = responseTimestamp;
	}

	@Override
	public String toString() {
		return "ApiLogEntry [apiLogEntryId=" + id + ", user=" + user
				+ ", machine=" + machine + ", requestIpAddress="
				+ requestIpAddress + ", requestContentType="
				+ requestContentType + ", requestContentBody="
				+ requestContentBody + ", requestUri=" + requestUri
				+ ", requestMethod=" + requestMethod + ", requestHeaders="
				+ requestHeaders + ", requestTimestamp=" + requestTimestamp
				+ ", responseContentType=" + responseContentType
				+ ", responseContentBody=" + responseContentBody
				+ ", responseStatusCode=" + responseStatusCode
				+ ", responseHeaders=" + responseHeaders
				+ ", responseTimestamp=" + responseTimestamp + "]";
	}

}