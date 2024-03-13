package com.nita.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nita.home.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
