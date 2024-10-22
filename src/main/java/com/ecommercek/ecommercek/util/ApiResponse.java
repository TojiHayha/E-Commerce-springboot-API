package com.ecommercek.ecommercek.util;

import java.time.Instant;

public record ApiResponse(boolean sucess, String message, String timestamp) {
	public ApiResponse(boolean success, String message) {
		this(success, message, Instant.now().toString());
	}
}
