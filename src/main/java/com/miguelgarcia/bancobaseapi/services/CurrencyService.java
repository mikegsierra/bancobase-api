package com.miguelgarcia.bancobaseapi.services;

import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;

public interface CurrencyService {
    Double getCurrencyValueByCode(CurrencyCode currencyCode);

    String formatValueByCurrencyCode(Double value, CurrencyCode currencyCode);

    Double changeCurrencyValueByCode(Double value, CurrencyCode currencyCode);
}
