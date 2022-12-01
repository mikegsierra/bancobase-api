package com.miguelgarcia.bancobaseapi.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miguelgarcia.bancobaseapi.dto.Expense;
import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;
import com.miguelgarcia.bancobaseapi.services.CustomerService;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    CustomerService service;

    @GetMapping("/{accountId}/expenses")
    public ArrayList<Expense> getExpensesByCategory(@PathVariable("accountId") long accountId,
            @RequestParam(required = false, defaultValue = "MXN") CurrencyCode currencyCode) {

        return service.getExpensesByCategory(accountId, currencyCode);
    }
}
