package com.nita.home.service;

import com.nita.home.dto.AccountDto;

public interface AccountServiceV1 {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto findByAccount(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    void suspendAccount(Long id);
}
