package com.api.bid_system.modules.bid.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateBidRequestDto {
    private String title;

    @JsonProperty("start_price")
    private Double startPrice;

    @JsonProperty("close_date")
    private LocalDateTime closeDate;
}
