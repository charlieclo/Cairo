package com.gdn.cairo.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Charlie Leonardo Oroh
 */

@Data
@ConfigurationProperties("spring.redis")
public class SpringRedisProperties {

  private String host;

  private String password;

  private int port;

  private int database;
}
