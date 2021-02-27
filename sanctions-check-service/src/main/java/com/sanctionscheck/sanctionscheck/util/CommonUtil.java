package com.sanctionscheck.sanctionscheck.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonUtil {

	public static <T> ResponseEntity<T> getFinalResponse(HttpStatus status, T result, Status statusCode,
			String statusDescription) {

		return new ResponseEntity<T>(result, status);
	}
}
