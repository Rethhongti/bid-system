package com.api.bid_system.modules.user_bid_history.services;

import com.api.bid_system.modules.user_bid_history.data.UserBidHistoryEntity;
import com.api.bid_system.modules.user_bid_history.data.UserBidReqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserBidService {
    void userBidItem(String username, UserBidReqDto payload);

    UserBidHistoryEntity findUserBidLargestById(Integer id);

    Page<UserBidHistoryEntity> getUserBidHistory(String username, Pageable option);
}
