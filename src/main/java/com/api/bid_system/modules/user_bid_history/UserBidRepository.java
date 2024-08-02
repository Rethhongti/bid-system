package com.api.bid_system.modules.user_bid_history;

import com.api.bid_system.modules.user_bid_history.data.UserBidHistoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserBidRepository extends JpaRepository<UserBidHistoryEntity, Integer> {
    @Query(value = "SELECT * FROM user_bid_histories WHERE user_bid_histories.bid_id = :id ORDER BY user_bid_histories.amount DESC LIMIT 1", nativeQuery = true)
    Optional<UserBidHistoryEntity> findLargestById(Integer id);

    Page<UserBidHistoryEntity> getUserBidHistoryEntitiesByUserId(Integer userId, Pageable option);
}
