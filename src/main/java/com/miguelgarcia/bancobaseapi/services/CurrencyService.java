package com.miguelgarcia.bancobaseapi.services;

import com.miguelgarcia.bancobaseapi.dto.TotalDescriptive;
import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;

public interface CurrencyService {
    String formatValueByCurrencyCode(Double value, CurrencyCode currencyCode);

    TotalDescriptive calculateTotalByCurrency(Double value, CurrencyCode currencyCode);
}
