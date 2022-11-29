package com.miguelgarcia.bancobaseapi.services;

import java.util.ArrayList;
import java.util.Optional;

import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;
import com.miguelgarcia.bancobaseapi.model.Account;
import com.miguelgarcia.bancobaseapi.model.Customer;

public interface CustomerService {
    ArrayList<Customer> getAllCustomers();

    Optional<Customer> getUserById(long id);

    ArrayList<Account> getAccountsByCustomerIdAndCurrency(long customerId, CurrencyCode currencyCode);
}
