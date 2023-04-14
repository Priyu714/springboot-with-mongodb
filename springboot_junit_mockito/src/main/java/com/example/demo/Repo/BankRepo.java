package com.example.demo.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entities.Bank;

public interface BankRepo extends MongoRepository<Bank, String> {

}
