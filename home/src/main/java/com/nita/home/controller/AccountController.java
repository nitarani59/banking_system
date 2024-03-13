package com.nita.home.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nita.home.dto.AccountDto;
import com.nita.home.service.AccountService;

@Controller
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findAccount(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.findByAccount(id), HttpStatus.OK);
    }

    @PutMapping("{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        return new ResponseEntity<>(accountService.deposit(id, request.get("balance")), HttpStatus.OK);
    }

    @PutMapping("{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        return new ResponseEntity<>(accountService.withdraw(id, request.get("balance")), HttpStatus.OK);
    }

    @DeleteMapping("{id}/removeAccount")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        accountService.suspendAccount(id);
        return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
    }
}
