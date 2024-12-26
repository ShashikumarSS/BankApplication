package com.cts.bankapp.service;

import java.util.List;

import com.cts.bankapp.entity.Account;

public interface AccountService 
{
	public Account createAccount(Account account);
	
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	
	public List<Account>  getAllAccountDetails();
	
	public Account depositMoney(Long accountNumber, Double amount);
	
	public Account withdrawAmount(Long accountNumber, Double amount);
	
	public void closeAccount(Long accountNumber);

}