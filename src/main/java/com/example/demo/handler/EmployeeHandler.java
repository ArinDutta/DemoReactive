package com.example.demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.rest.vm.Employee;
import com.example.demo.service.EmployeeService;

import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {

	@Autowired
	private EmployeeService employeeService;

	public Mono<ServerResponse> saveEmployee(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(employeeService.save(request.bodyToMono(Employee.class)),Boolean.class);
	}

	public Mono<ServerResponse> findEmployee(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(employeeService.findEmployee(request.pathVariable("empId")), Employee.class);
	}

	public Mono<ServerResponse> findEmployeeAll(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(employeeService.findAll(),Employee.class);
	}

	public Mono<ServerResponse> deleteEmployee(ServerRequest request) {
		return ServerResponse.ok().body(employeeService.delete(request.pathVariable("empId")),Boolean.class);
	}
	
	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().body("Hello",String.class);
	}

}
