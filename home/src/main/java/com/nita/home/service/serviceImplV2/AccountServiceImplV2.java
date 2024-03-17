package com.nita.home.service.serviceImplV2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nita.home.dto.AccountDto;
import com.nita.home.dto.AccountResponseDto;
import com.nita.home.entity.Account;
import com.nita.home.mapper.AccountMapping;
import com.nita.home.repository.AccountRepository;
import com.nita.home.service.AccountServiceV2;
import com.nita.home.service.serviceImplV1.AccountServiceImplV1;

@Service
@Qualifier("v2")
public class AccountServiceImplV2 extends AccountServiceImplV1 implements AccountServiceV2 {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public double checkBalance(Long id) {
       Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Id does not exist."));
        return account.getBalance();
    }

    @Override
    public List<AccountDto> findByAccountHolder(String accountHolder) {
        List<Account> account = accountRepository.findByAccountHolder(accountHolder);
        List<AccountDto> list = new ArrayList<>();
        for(Account account2 : account) {
            list.add(AccountMapping.mapToAccountDto(account2));
        }
        return list;
    }

    @Override
    public AccountResponseDto findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Account> page2 = accountRepository.findAll(pageable);
        List<Account> list = page2.getContent();
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        List<AccountDto> l1 =  list.stream().map(l -> AccountMapping.mapToAccountDto(l)).collect(Collectors.toList());
        accountResponseDto.setData(l1);
        accountResponseDto.setLastPage(page2.isLast());
        accountResponseDto.setPageNumber(page2.getNumber());
        accountResponseDto.setPageSize(page2.getSize());
        accountResponseDto.setTotalElements(page2.getTotalElements());
        accountResponseDto.setTotalPageSize(page2.getTotalPages());
        return accountResponseDto;
    }
}
