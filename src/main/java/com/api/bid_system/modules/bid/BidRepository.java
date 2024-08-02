package com.api.bid_system.modules.bid;

import com.api.bid_system.modules.bid.data.BidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidEntity, Integer> {
}
