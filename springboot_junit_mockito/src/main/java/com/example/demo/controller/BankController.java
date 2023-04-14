package com.example.demo.controller;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.BankRepo;
import com.example.demo.entities.Bank;


@RestController
@RequestMapping("/bankOpretion")
public class BankController {

	@Autowired
	private BankRepo bankRepo;

	@PostMapping("/postBank")
	public Bank createBank(@RequestBody Bank bank) {
		bankRepo.save(bank);

		return bank;

	}

	@PutMapping("/putBank/{bankId}")
	public Bank updateBank(@RequestBody Bank bank, @PathVariable String bankId) {
		Optional<Bank> bk = bankRepo.findById(bankId);
		Bank bk1 = bk.get();
		bk1.setBankId(bank.getBankId());
		bk1.setBankName(bank.getBankName());
		bk1.setBranch(bank.getBranch());
		bankRepo.save(bk1);
		return bk1;

	}

	@GetMapping("/getBank")
	public List<Bank> getAllBank() {

		return bankRepo.findAll();

	}

	@DeleteMapping("/deleteBank/{bankId}")
	public String deleteBank(@PathVariable String bankId) {
		bankRepo.deleteById(bankId);
		return "delete succesfully bank with id :" + bankId;

	}

}
