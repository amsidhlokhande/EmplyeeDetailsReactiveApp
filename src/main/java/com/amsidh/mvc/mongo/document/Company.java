package com.amsidh.mvc.mongo.document;

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
public class Company {
	@Id
	private String companyId;
	private String companyName;
	private List<Address> companyOfficeAddresses;

}
