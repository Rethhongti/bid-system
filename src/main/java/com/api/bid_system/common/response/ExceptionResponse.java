package com.api.bid_system.common.response;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        HttpStatus status,
        String message
) {
}
