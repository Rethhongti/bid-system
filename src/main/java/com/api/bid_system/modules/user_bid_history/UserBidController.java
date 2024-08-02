package com.api.bid_system.modules.user_bid_history;

import com.api.bid_system.common.response.BaseResponse;
import com.api.bid_system.common.response.PaginationResDto;
import com.api.bid_system.modules.bid.services.BidServiceImpl;
import com.api.bid_system.modules.user_bid_history.data.UserBidHistoryEntity;
import com.api.bid_system.modules.user_bid_history.data.UserBidReqDto;
import com.api.bid_system.modules.user_bid_history.services.UserBidServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserBidController {
    private final UserBidServiceImpl userBidService;

    @PreAuthorize("hasAuthority('SCOPE_WRITE')")
    @PostMapping("/bid-item")
    ResponseEntity<BaseResponse<String>> bidItem(@RequestBody UserBidReqDto payload, Authentication authentication) {
        String username = authentication.getName();

        userBidService.userBidItem(username, payload);
        return ResponseEntity.ok(new BaseResponse<String>("You've bid item successfully."));
    }

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/largest-bid-amount")
    ResponseEntity<BaseResponse<UserBidHistoryEntity>> getLargestBidAmount(@RequestParam(name = "id") Integer id) {
        var res = userBidService.findUserBidLargestById(id);
        return ResponseEntity.ok(new BaseResponse<>(res));
    }

    @PreAuthorize("hasAuthority('SCOPE_READ')")
    @GetMapping("/user-histories")
    ResponseEntity<PaginationResDto> getUserHistory(
            @RequestParam(name = "page",defaultValue = "1") Integer page,
            @RequestParam(name = "limit", defaultValue = "10") Integer limit,
            Authentication authentication
    ) {
        String username = authentication.getName();

        var data = userBidService.getUserBidHistory(username, PageRequest.of(page - 1, limit));
        PaginationResDto response = new PaginationResDto(data, page);
        return ResponseEntity.ok(response);
    }
}
