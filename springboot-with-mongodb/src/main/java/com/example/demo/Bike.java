package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Bike {

	@MongoId
	private Long id;
	private String bikeModel;
	private String bikeCompany;
	private Double bikePrice;
	private String bikeRating;
	private List<BikeDetails> bikeDetails;
	private BikeDetails bikeDetails1;
}
