package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.example.demo.rest.vm.Employee;

@Configuration
public class CacheConfig {
	
	@Bean
	public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
		return new LettuceConnectionFactory(redisStandaloneConfiguration());
	}
	
	@Bean
	public RedisStandaloneConfiguration redisStandaloneConfiguration() {
		return new RedisStandaloneConfiguration("localhost", 6379);
	}
	
	@Bean
	public ReactiveRedisTemplate<String, Employee> reactiveRedisTemplate(){
		Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);
	    RedisSerializationContext.RedisSerializationContextBuilder<String, Employee> builder =
	        RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
	    RedisSerializationContext<String, Employee> context = builder.value(serializer).build();
	  return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory(), context);
	}

}
