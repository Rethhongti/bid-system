package com.api.bid_system.modules.user_bid_history.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserBidReqDto {

    @JsonProperty("bid_id")
    private Integer bidId;

    private Double amount;
}
