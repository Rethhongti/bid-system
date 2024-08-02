package com.api.bid_system.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix = "jwt")
public record RsaKeyRecord(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
}
