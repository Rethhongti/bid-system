package com.api.bid_system.modules.user.services;

import com.api.bid_system.exceptions.NotFoundException;
import com.api.bid_system.modules.user.data.UserEntity;
import com.api.bid_system.modules.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepo.getUserEntitiesByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found!!!"));
    }
}
