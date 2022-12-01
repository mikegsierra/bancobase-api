package com.miguelgarcia.bancobaseapi.dto;

public interface ExpenseProjection {
    int getId();

    String getCode();

    String getName();

    Double getTotal();
}
