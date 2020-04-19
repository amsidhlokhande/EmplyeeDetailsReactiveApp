package com.amsidh.mvc.router.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.amsidh.mvc.mongo.document.Employee;
import com.amsidh.mvc.mongo.repositories.EmployeeRepository;

import reactor.core.publisher.Mono;

@Component
public class EmployeeRequestHandler {
	private EmployeeRepository employeeRepository;

	public EmployeeRequestHandler(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Mono<ServerResponse> getAllEmployee(ServerRequest serverRequest) {
		return ServerResponse.ok().body(employeeRepository.findAll(), Employee.class);
	}

	public Mono<ServerResponse> getEmployeeByEmployeeId(ServerRequest serverRequest) {
		return ServerResponse.ok().body(employeeRepository.findById(serverRequest.pathVariable("employeeId")),
				Employee.class);
	}
}
