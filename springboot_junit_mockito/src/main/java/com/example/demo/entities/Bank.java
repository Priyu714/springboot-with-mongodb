package com.example.demo.entities;



import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Bank {

	@MongoId
	private String bankId;
	private String bankName;
	private String branch;
	private Customer customer;

}
