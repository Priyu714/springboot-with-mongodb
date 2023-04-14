package com.exa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exa.demo.model.Shop;
import com.exa.demo.repo.ShopRepository;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopRepository shopRepository;
	
	@GetMapping("/allshop")
	public List<Shop> getAllShops(){
		return shopRepository.findAll();
	}
	
	
	@GetMapping("/shopbyid/{id}")
	public Shop getStoreById(@PathVariable String id) {
		return shopRepository.findById(id).get();
	}
	
	@PostMapping("/saveshop")
	public Shop saveStore(@RequestBody Shop shop) {
		 shopRepository.save(shop);
		return shop;
	}
	
}
