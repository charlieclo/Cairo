package com.gdn.cairo.core.client.config;

import com.gdn.cairo.core.properties.SpringRedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Charlie Leonardo Oroh
 */

@Configuration
public class RedisConfiguration {

  @Autowired
  private SpringRedisProperties springRedisProperties;

  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory factory = new JedisConnectionFactory();
    factory.setHostName(springRedisProperties.getHost());
    factory.setPort(springRedisProperties.getPort());
    factory.setDatabase(springRedisProperties.getDatabase());
    return factory;
  }

  @Bean
  RedisTemplate<String, String> redisTemplate() {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    return redisTemplate;
  }
}
