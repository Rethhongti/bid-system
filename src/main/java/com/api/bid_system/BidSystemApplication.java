package com.api.bid_system;

import com.api.bid_system.config.RsaKeyRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyRecord.class)
@SpringBootApplication
public class BidSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidSystemApplication.class, args);
	}

}
