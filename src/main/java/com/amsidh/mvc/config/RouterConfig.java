package com.amsidh.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.amsidh.mvc.router.handler.CompanyRequestHandler;
import com.amsidh.mvc.router.handler.EmployeeRequestHandler;

@Configuration
public class RouterConfig {

	@Autowired(required = true)
	private EmployeeRequestHandler employeeRequestHandler;

	@Autowired(required = true)
	private CompanyRequestHandler companyRequestHandler;

	@Bean
	public RouterFunction<ServerResponse> getEmployeeRouterFunction() {
		return RouterFunctions.route(RequestPredicates.GET("/employees"), employeeRequestHandler::getAllEmployee)
				.andRoute(RequestPredicates.GET("/Employees/{employeeId}"),
						employeeRequestHandler::getEmployeeByEmployeeId);
	}

	@Bean
	public RouterFunction<ServerResponse> getCompanyRouterFunction() {
		return RouterFunctions.route(RequestPredicates.GET("/companies"), companyRequestHandler::getAllCompanies)
				.andRoute(RequestPredicates.GET("/companies/{companyId}"),
						companyRequestHandler::getCompanyByCompanyId);
	}
}
