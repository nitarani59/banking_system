package com.nita.home.mapper;

import com.nita.home.dto.AccountDto;
import com.nita.home.entity.Account;

public class AccountMapping {
    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
            account.getId(),
            account.getAccountHolder(),
            account.getBalance()
        );
        return accountDto;
    }

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
            accountDto.getId(),
            accountDto.getAccountHolder(),
            accountDto.getBalance()
        );
        return account;
    }
}
