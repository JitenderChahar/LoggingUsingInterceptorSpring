package com.jsc.javageeks.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {
	private String requestBody;

	public MultiReadHttpServletRequest(HttpServletRequest request)
			throws IOException {
		super(request);
		requestBody = "";
		BufferedReader bufferedReader = request.getReader();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			requestBody += line;
		}
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
				requestBody.getBytes());
		return new ServletInputStream() {
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}
		};
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}
}