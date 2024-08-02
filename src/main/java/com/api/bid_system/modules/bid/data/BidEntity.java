package com.api.bid_system.modules.bid.data;

import com.api.bid_system.common.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "bids")
@Getter
@Setter
@NoArgsConstructor
public class BidEntity extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "start_price")
    private Double startPrice;

    @Column(name = "close_date")
    private LocalDateTime closeDate;
}
