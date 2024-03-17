package com.nita.home.service;

import java.util.List;

import com.nita.home.dto.AccountDto;
import com.nita.home.dto.AccountResponseDto;

public interface AccountServiceV2 extends AccountServiceV1{
    double checkBalance(Long id);
    List<AccountDto> findByAccountHolder(String accountHolder);
    AccountResponseDto findAll(int page, int size);
}
