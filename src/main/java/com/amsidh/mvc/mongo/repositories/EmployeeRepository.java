package com.amsidh.mvc.mongo.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.amsidh.mvc.mongo.document.Employee;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

	
}
