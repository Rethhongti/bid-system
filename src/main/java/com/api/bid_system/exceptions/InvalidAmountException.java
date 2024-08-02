package com.api.bid_system.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class InvalidAmountException extends RuntimeException {
    private final String message;
}
