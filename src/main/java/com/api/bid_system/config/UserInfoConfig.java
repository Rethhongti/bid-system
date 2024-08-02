package com.api.bid_system.config;

import com.api.bid_system.modules.user.data.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@RequiredArgsConstructor
public class UserInfoConfig implements UserDetails {
    private final UserEntity userEntity;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] roles = new String[]{"user", "back_office"};
        return Arrays.stream(userEntity.getRole().split(",")).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
