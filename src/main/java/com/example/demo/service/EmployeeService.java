package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.rest.vm.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface EmployeeService {
	
	 Mono<Boolean>  save(Mono<Employee> e);
	 Mono<Employee> findEmployee(String empId);
	 Mono<Boolean>  delete(String empId);
	 Flux<Employee> findAll();

}
