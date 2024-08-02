package com.api.bid_system.modules.user;

import com.api.bid_system.modules.user.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> getUserEntitiesByUsername(String username);
}
