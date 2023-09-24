package com.wooper.rooper.common.vo;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ResponseStdVo<T> {

	private final HttpStatus status;

	private final String message;

	private final T data;

	public ResponseStdVo(HttpStatus status, String message) {
		this(status, message, null);
	}

	public ResponseStdVo(HttpStatus status, T data) {
		this(status, "", data);
	}

	public ResponseStdVo(HttpStatus status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
}
