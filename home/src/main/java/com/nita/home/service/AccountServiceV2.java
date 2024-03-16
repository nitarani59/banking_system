package com.nita.home.service;

import java.util.List;

import com.nita.home.dto.AccountDto;

public interface AccountServiceV2 extends AccountServiceV1{
    double checkBalance(Long id);
    List<AccountDto> findByAccountHolder(String accountHolder);
}
