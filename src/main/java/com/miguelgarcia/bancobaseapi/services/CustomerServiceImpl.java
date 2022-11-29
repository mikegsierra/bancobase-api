package com.miguelgarcia.bancobaseapi.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;
import com.miguelgarcia.bancobaseapi.model.Account;
import com.miguelgarcia.bancobaseapi.model.Customer;
import com.miguelgarcia.bancobaseapi.repositories.AccountRepository;
import com.miguelgarcia.bancobaseapi.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CurrencyService currencyService;

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getUserById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public ArrayList<Account> getAccountsByCustomerIdAndCurrency(long customerId, final CurrencyCode currencyCode) {

        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAccountsByCustomerId(customerId);

        accounts.forEach(account -> {
            Double newBalanceTransformed = currencyService.changeCurrencyValueByCode(account.getBalance(),
                    currencyCode);
            account.setBalance(newBalanceTransformed);

            String balanceFormatted = currencyService.formatValueByCurrencyCode(newBalanceTransformed, currencyCode);
            account.setBalanceText(balanceFormatted);
        });

        return accounts;
    }
}
