package com.example.demo.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.handler.EmployeeHandler;

@Configuration
public class EmployeeRouter {
    
	@Bean
	public RouterFunction<ServerResponse> route(EmployeeHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.GET("/demo/employee/{empId}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findEmployee)
				.andRoute(RequestPredicates.GET("/demo/employee/all/details").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findEmployeeAll)
				.andRoute(RequestPredicates.PUT("/demo/employee").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::saveEmployee)
				.andRoute(RequestPredicates.DELETE("/demo/employee/{empId}/delete").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::deleteEmployee);
	}

}
