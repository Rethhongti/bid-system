package com.api.bid_system.modules.user_bid_history.services;

import com.api.bid_system.exceptions.InvalidAmountException;
import com.api.bid_system.exceptions.NotFoundException;
import com.api.bid_system.modules.bid.data.BidEntity;
import com.api.bid_system.modules.bid.services.BidService;
import com.api.bid_system.modules.user.data.UserEntity;
import com.api.bid_system.modules.user.services.UserService;
import com.api.bid_system.modules.user_bid_history.UserBidRepository;
import com.api.bid_system.modules.user_bid_history.data.UserBidHistoryEntity;
import com.api.bid_system.modules.user_bid_history.data.UserBidReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBidServiceImpl implements UserBidService {
    private final UserService userService;
    private final UserBidRepository userBidRepo;
    private final BidService bidService;

    @Override
    public void userBidItem(String username, UserBidReqDto payload) {
        UserEntity user = userService.getUserByUsername(username);
        BidEntity bidItem = bidService.getBidById(payload.getBidId());
        UserBidHistoryEntity userBidHistory = userBidRepo.findLargestById(bidItem.getId()).orElse(null);

        if(userBidHistory != null && payload.getAmount() <= userBidHistory.getAmount()) {
            throw new InvalidAmountException("Bid amount should greater than largest bided: " + userBidHistory.getAmount());
        } else if(payload.getAmount() <= bidItem.getStartPrice()) {
            throw new InvalidAmountException("Bid amount should greater than start price: " + bidItem.getStartPrice());
        }

        UserBidHistoryEntity userBid = new UserBidHistoryEntity();
        userBid.setBidId(payload.getBidId());
        userBid.setUserId(user.getId());
        userBid.setAmount(payload.getAmount());

        userBidRepo.save(userBid);
    }

    @Override
    public UserBidHistoryEntity findUserBidLargestById(Integer id) {
        return userBidRepo.findLargestById(id).orElseThrow(() -> new NotFoundException("Bid item id: " + id + "not bidded yet."));
    }

    @Override
    public Page<UserBidHistoryEntity> getUserBidHistory(String username, Pageable option) {
        UserEntity user = userService.getUserByUsername(username);

        return userBidRepo.getUserBidHistoryEntitiesByUserId(user.getId(), option);
    }
}
