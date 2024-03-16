package com.nita.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nita.home.service.AccountServiceV2;

@RestController
@RequestMapping("/api/v2/account")
public class AccountControllerV2 {
    
    @Autowired
    @Qualifier("v2")
    AccountServiceV2 accountServiceV2;

    @GetMapping("/checkBalance/{id}")
    public ResponseEntity<Double> checkBalance(@PathVariable Long id) {
        double balance = accountServiceV2.checkBalance(id);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
