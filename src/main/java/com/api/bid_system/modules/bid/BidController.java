package com.api.bid_system.modules.bid;

import com.api.bid_system.common.response.BaseResponse;
import com.api.bid_system.modules.bid.data.BidEntity;
import com.api.bid_system.modules.bid.data.CreateBidRequestDto;
import com.api.bid_system.modules.bid.services.BidServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BidController {
    private final BidServiceImpl bidService;

    @PreAuthorize("hasAuthority('SCOPE_CREATE_BID')")
    @PostMapping("/create-bid-item")
    ResponseEntity<BaseResponse<BidEntity>> createBidItem(@RequestBody CreateBidRequestDto payload) {
        var response = bidService.createBidItem(payload);
        return ResponseEntity.ok(new BaseResponse<BidEntity>(response));
    }
}
