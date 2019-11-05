package com.gdn.cairo.core;

import com.gdn.cairo.core.properties.SpringRedisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Charlie Leonardo Oroh
 */

@EnableJpaRepositories
@EnableConfigurationProperties(value = {SpringRedisProperties.class})
@SpringBootApplication
public class CairoCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CairoCoreApplication.class, args);
	}

}
