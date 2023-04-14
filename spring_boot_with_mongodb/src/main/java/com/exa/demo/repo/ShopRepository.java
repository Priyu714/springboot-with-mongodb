package com.exa.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exa.demo.model.Shop;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String>{

}
