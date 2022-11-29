package com.miguelgarcia.bancobaseapi.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;
import com.miguelgarcia.bancobaseapi.model.Account;
import com.miguelgarcia.bancobaseapi.model.Customer;
import com.miguelgarcia.bancobaseapi.services.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping
    public ArrayList<Customer> getAllCustomers() {
        return (ArrayList<Customer>) service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") long id) {
        return service.getUserById(id);
    }

    @GetMapping("/{customerId}/accounts")
    public ArrayList<Account> getAccountsByCustomerId(@PathVariable("customerId") long customerId,
            @RequestParam(required = false, defaultValue = "MXN") CurrencyCode currencyCode) {

        return service.getAccountsByCustomerIdAndCurrency(customerId, currencyCode);
    }
}
