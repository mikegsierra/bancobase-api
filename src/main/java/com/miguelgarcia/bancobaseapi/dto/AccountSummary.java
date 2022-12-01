package com.miguelgarcia.bancobaseapi.dto;

import java.util.ArrayList;

import com.miguelgarcia.bancobaseapi.model.Account;

public class AccountSummary {
    private ArrayList<Account> accounts;
    private double total;
    private String totalText;
    private int size;

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTotalText() {
        return this.totalText;
    }

    public void setTotalText(String totalText) {
        this.totalText = totalText;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
