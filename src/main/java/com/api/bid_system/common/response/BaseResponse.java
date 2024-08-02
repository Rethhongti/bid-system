package com.api.bid_system.common.response;

public record BaseResponse<T>(
        T data
) {}
