package com.api.bid_system.config;

import com.api.bid_system.modules.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoManager implements UserDetailsService {
    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.getUserEntitiesByUsername(username)
                .map(UserInfoConfig::new)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + "does not exist"));
    }
}
