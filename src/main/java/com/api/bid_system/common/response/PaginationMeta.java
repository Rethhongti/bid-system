package com.api.bid_system.common.response;

public record PaginationMeta(
        Long totalItems,
        Integer totalPages,
        Integer currentPage,
        Boolean hasNext
) {
}
