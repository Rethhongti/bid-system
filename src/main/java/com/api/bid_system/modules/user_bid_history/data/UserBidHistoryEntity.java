package com.api.bid_system.modules.user_bid_history.data;

import com.api.bid_system.common.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_bid_histories")
@Getter
@Setter
@NoArgsConstructor
public class UserBidHistoryEntity extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "bid_id")
    private Integer bidId;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private UserBidStatus status;
}
