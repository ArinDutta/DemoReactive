package com.example.demo.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.rest.vm.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ReactiveRedisTemplate<String, Employee> reactiveRedisTemplate;
	
	private static final String EMPLOYEE_CACHE_KEY="Employee_";

	@Override
	public Mono<Boolean> save(Mono<Employee> e) {
		return e.flatMap(k ->  
		{
			reactiveRedisTemplate.expire(EMPLOYEE_CACHE_KEY+k.getEmpId(), Duration.ofMinutes(60));
			return reactiveRedisTemplate.opsForValue().set(EMPLOYEE_CACHE_KEY + k.getEmpId(), k); 
		});
	}

	@Override
	public Mono<Employee> findEmployee(String empId) {
		return reactiveRedisTemplate.opsForValue().get(EMPLOYEE_CACHE_KEY + empId);
	}

	@Override
	public Mono<Boolean> delete(String empId) {
		return reactiveRedisTemplate.opsForValue().delete(EMPLOYEE_CACHE_KEY + empId);
	}

	@Override
	public Flux<Employee> findAll() {
		return reactiveRedisTemplate.keys(EMPLOYEE_CACHE_KEY+"*").flatMap(e -> reactiveRedisTemplate.opsForValue().get(e))
				.collectList().flatMapMany(Flux::fromIterable);
	}

}
