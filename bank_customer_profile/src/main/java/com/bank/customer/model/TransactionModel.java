package com.bank.customer.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionModel  {
	private String transaction_id;
	private String from_account;
	private String to_account;
	private Double transaction_amount;
	private Date transaction_date;
}
