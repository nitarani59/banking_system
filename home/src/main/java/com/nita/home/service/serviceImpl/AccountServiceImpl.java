package com.nita.home.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nita.home.dto.AccountDto;
import com.nita.home.entity.Account;
import com.nita.home.mapper.AccountMapping;
import com.nita.home.repository.AccountRepository;
import com.nita.home.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapping.mapToAccount(accountDto);
         accountRepository.save(account);
         return AccountMapping.mapToAccountDto(account);
    }

    @Override
    public AccountDto findByAccount(Long id) {
        Account account = accountRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapping.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        
        Account account = accountRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Account does not exist"));
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
        return AccountMapping.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Account does not exist"));
    account.setBalance(account.getBalance() - amount);
    accountRepository.save(account);
    return AccountMapping.mapToAccountDto(account);
    }

    @Override
    public void suspendAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
