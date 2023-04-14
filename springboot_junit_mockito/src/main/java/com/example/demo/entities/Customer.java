package com.example.demo.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
	private String CustId;
	private String CustName;
	private String email;
	private Long accountNo;

}
