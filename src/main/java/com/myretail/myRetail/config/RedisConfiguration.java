package com.myretail.myRetail.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableCaching
public class RedisConfiguration {
	/*
	 * @Bean JedisConnectionFactory jedisConnectionFactory() {
	 * RedisStandaloneConfiguration configuration = new
	 * RedisStandaloneConfiguration("localhost", 6379); return new
	 * JedisConnectionFactory(configuration.);
	 * 
	 * }
	 * 
	 * @Bean RedisTemplate<String, ProductDetails> redisTemplate(){
	 * RedisTemplate<String, ProductDetails> redisTemplate= new
	 * RedisTemplate<String, ProductDetails>();
	 * redisTemplate.setConnectionFactory(jedisConnectionFactory()); return
	 * redisTemplate; }
	 */
	
	/*
	 * @Bean public LettuceConnectionFactory redisConnectionFactory() {
	 * RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
	 * redisConf.setHostName(env.getProperty("spring.redis.host"));
	 * redisConf.setPort(Integer.parseInt(env.getRequiredProperty(
	 * "spring.redis.port"))); return new LettuceConnectionFactory(redisConf); }
	 * 
	 * @Bean public RedisCacheManager cacheManager() { RedisCacheManager rcm =
	 * RedisCacheManager.create(redisConnectionFactory());
	 * rcm.setTransactionAware(true); return rcm; }
	 */

}
