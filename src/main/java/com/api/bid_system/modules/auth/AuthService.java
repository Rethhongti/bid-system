package com.api.bid_system.modules.auth;

import com.api.bid_system.common.JwtTokenGenerator;
import com.api.bid_system.modules.auth.dto.AuthResponseDto;
import com.api.bid_system.modules.auth.dto.TokenType;
import com.api.bid_system.modules.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepo;
    private final JwtTokenGenerator jwtTokenGenerator;
    private AuthenticationManager authenticationManager;
    public AuthResponseDto getJwtTokensAfterAuthentication(Authentication authentication) {
        try
        {
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword());
//
//            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            var userInfoEntity = userRepo.getUserEntitiesByUsername(authentication.getName())
                    .orElseThrow(()->{
                        log.error("[AuthService:userSignInAuth] User :{} not found",authentication.getName());
                        return new ResponseStatusException(HttpStatus.NOT_FOUND,"USER NOT FOUND ");});


            String accessToken = jwtTokenGenerator.generateAccessToken(authentication);

            log.info("[AuthService:userSignInAuth] Access token for user:{}, has been generated",userInfoEntity.getUsername());
            return  AuthResponseDto.builder()
                    .accessToken(accessToken)
                    .accessTokenExpiry(15 * 60)
                    .userName(userInfoEntity.getUsername())
                    .tokenType(TokenType.Bearer)
                    .build();


        }catch (Exception e){
            log.error("[AuthService:userSignInAuth]Exception while authenticating the user due to :"+e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        }
    }
}
