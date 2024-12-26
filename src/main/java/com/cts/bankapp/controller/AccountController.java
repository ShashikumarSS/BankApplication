package com.cts.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bankapp.entity.Account;
import com.cts.bankapp.service.AccountService;

@RestController
@RequestMapping
public class AccountController 
{
	@Autowired
	AccountService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account)
	{
		Account createAccount = service.createAccount(account);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
		
	}
	
	@GetMapping("{account_number}")
	public Account getAccountByAccountNumber(@PathVariable Long account_number)
	{
		Account account = service.getAccountDetailsByAccountNumber(account_number);
		return account;
	}
	
	@GetMapping("/getAll")
	public List<Account> getAllAccounts()
	{
		List<Account> allAccountDetails = service.getAllAccountDetails();
		return allAccountDetails;
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount)
	{
		Account account = service.depositMoney(accountNumber, amount);
		return account;
	}
	
	@PutMapping("/withdrawl/{accountNumber}/{amount}")
	public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount)
	{
		Account account = service.withdrawAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity deleteAccount(@PathVariable Long accountNumber)
	{
		service.closeAccount(accountNumber);
		return ResponseEntity.ok("Account closed");
	}

}
