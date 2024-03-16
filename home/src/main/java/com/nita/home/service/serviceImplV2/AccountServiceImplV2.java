package com.nita.home.service.serviceImplV2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nita.home.entity.Account;
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
}
