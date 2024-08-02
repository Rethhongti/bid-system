package com.api.bid_system.modules.user.services;

import com.api.bid_system.modules.user.data.UserEntity;

public interface UserService {
    UserEntity getUserByUsername(String username);
}
