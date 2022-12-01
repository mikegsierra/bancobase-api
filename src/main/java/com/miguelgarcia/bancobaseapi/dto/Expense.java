package com.miguelgarcia.bancobaseapi.dto;

public class Expense {
    private int id;
    private String code;
    private String name;
    private Double total;
    private String totalText;

    public Expense(ExpenseProjection projection) {
        this.id = projection.getId();
        this.code = projection.getCode();
        this.name = projection.getName();
        this.total = projection.getTotal();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTotalText() {
        return this.totalText;
    }

    public void setTotalText(String totalText) {
        this.totalText = totalText;
    }

}
