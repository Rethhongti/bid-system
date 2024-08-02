package com.api.bid_system.common.response;

import org.springframework.data.domain.Page;

import java.util.List;

public class PaginationResDto {
    public PaginationMeta meta;
    public List<?> data;

    public PaginationResDto(Page<?> pageData, Integer page) {
        PaginationMeta meta = new PaginationMeta(pageData.getTotalElements(), pageData.getTotalPages(), page, pageData.hasNext());

        this.data = pageData.getContent();
        this.meta = meta;
    }
}
