package com.amsidh.mvc.mongo.document;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  @Id
  private String employeeId;
  private String employeeName;
  private String emailId;
  private Date  dateOfBirth;
  private Double salary;
  private Address address;
  private List<Company> companies;
  
  
	
}
