package com.bank.customer.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bank.customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    @Query("{account :?0}")                                             
    Optional<Customer> getAccountById(String id);
}
