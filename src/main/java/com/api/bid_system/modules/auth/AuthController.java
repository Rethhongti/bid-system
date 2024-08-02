package com.api.bid_system.modules.auth;

import com.api.bid_system.modules.auth.dto.SignInRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(Authentication authentication) {

        return ResponseEntity.ok(authService.getJwtTokensAfterAuthentication(authentication));
    }

//    @PostMapping("/sign-in")
//    public ResponseEntity<?> authenticateUser(@RequestBody SignInRequestDto requestDto) {
//        return ResponseEntity.ok(authService.getJwtTokensAfterAuthentication(requestDto));
//    }
}
