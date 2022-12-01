package com.miguelgarcia.bancobaseapi.services;

import java.util.ArrayList;
import java.util.Optional;

import com.miguelgarcia.bancobaseapi.dto.AccountSummary;
import com.miguelgarcia.bancobaseapi.dto.Expense;
import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;
import com.miguelgarcia.bancobaseapi.model.Customer;

public interface CustomerService {
    Optional<Customer> getUserById(long id);

    AccountSummary getAccountSummaryByCustomerIdAndCurrency(long customerId, CurrencyCode currencyCode);

    ArrayList<Expense> getExpensesByCategory(long accountId, CurrencyCode currencyCode);
}
