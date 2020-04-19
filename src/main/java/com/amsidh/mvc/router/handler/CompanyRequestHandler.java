package com.amsidh.mvc.router.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.amsidh.mvc.mongo.document.Company;
import com.amsidh.mvc.mongo.repositories.CompanyRepository;

import reactor.core.publisher.Mono;

@Component
public class CompanyRequestHandler {

	private CompanyRepository companyRepository;
	public CompanyRequestHandler(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	

	public Mono<ServerResponse> getAllCompanies(ServerRequest serverRequest) {
		return ServerResponse.ok().body(companyRepository.findAll(), Company.class);
	}
	
	public Mono<ServerResponse> getCompanyByCompanyId(ServerRequest serverRequest) {
		return ServerResponse.ok().body(companyRepository.findById(serverRequest.pathVariable("companyId")),Company.class);
	}
}
