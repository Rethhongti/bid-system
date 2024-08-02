package com.api.bid_system.modules.bid.services;

import com.api.bid_system.modules.bid.data.BidEntity;
import com.api.bid_system.modules.bid.data.CreateBidRequestDto;

public interface BidService {
    BidEntity createBidItem(CreateBidRequestDto requestDto);

    BidEntity getBidById(Integer id);
}
