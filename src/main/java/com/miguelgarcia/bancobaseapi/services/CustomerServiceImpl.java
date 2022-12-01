package com.miguelgarcia.bancobaseapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelgarcia.bancobaseapi.dto.AccountSummary;
import com.miguelgarcia.bancobaseapi.dto.Expense;
import com.miguelgarcia.bancobaseapi.dto.ExpenseProjection;
import com.miguelgarcia.bancobaseapi.dto.TotalDescriptive;
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
    public Optional<Customer> getUserById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public AccountSummary getAccountSummaryByCustomerIdAndCurrency(long customerId, final CurrencyCode currencyCode) {

        AccountSummary dto = new AccountSummary();
        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAccountsByCustomerId(customerId);

        calculateAndFormatBalanceByDivisa(accounts, currencyCode);

        dto.setAccounts(accounts);
        dto.setSize(accounts.size());

        Double total = sumTotalBalanceFromAccounts(accounts);
        dto.setTotal(total);

        String totalFormatted = currencyService.formatValueByCurrencyCode(total, currencyCode);
        dto.setTotalText((totalFormatted));

        return dto;
    }

    @Override
    public ArrayList<Expense> getExpensesByCategory(long accountId, CurrencyCode currencyCode) {
        ArrayList<ExpenseProjection> expenses = (ArrayList<ExpenseProjection>) accountRepository
                .findExpensesByCategory(accountId);

        return (ArrayList<Expense>) expenses.stream().map(projection -> {
            Expense expense = new Expense(projection);

            TotalDescriptive totalDescriptive = currencyService.calculateTotalByCurrency(expense.getTotal(),
                    currencyCode);
            expense.setTotal(totalDescriptive.getTotal());
            expense.setTotalText(totalDescriptive.getTotalText());

            return expense;
        }).collect(Collectors.toList());
    }

    private void calculateAndFormatBalanceByDivisa(ArrayList<Account> accounts,
            CurrencyCode currencyCode) {

        accounts.stream().forEach(account -> {
            TotalDescriptive total = currencyService.calculateTotalByCurrency(account.getBalance(), currencyCode);

            account.setBalance(total.getTotal());
            account.setBalanceText(total.getTotalText());
        });
    }

    private Double sumTotalBalanceFromAccounts(ArrayList<Account> accounts) {
        return accounts.stream().mapToDouble(x -> x.getBalance()).sum();
    }

}
