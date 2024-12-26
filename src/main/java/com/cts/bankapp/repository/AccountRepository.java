package com.cts.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
