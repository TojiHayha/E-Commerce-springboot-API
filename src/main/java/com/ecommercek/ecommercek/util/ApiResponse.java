package com.ecommercek.ecommercek.util;

public record ApiResponse(boolean sucess, String message, String timestamp) {
	public ApiResponse(boolean success, String message) {
		this(success, message, message);
	}
}
