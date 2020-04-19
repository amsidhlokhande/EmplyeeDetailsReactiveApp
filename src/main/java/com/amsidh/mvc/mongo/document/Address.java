package com.amsidh.mvc.mongo.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String addressId;
    private String city;
    private String state;
    private String country;
    private Long pincode;
    
}
