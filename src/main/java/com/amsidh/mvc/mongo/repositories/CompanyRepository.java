package com.amsidh.mvc.mongo.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.amsidh.mvc.mongo.document.Company;
@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

}
