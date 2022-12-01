package com.miguelgarcia.bancobaseapi.services;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.miguelgarcia.bancobaseapi.dto.TotalDescriptive;
import com.miguelgarcia.bancobaseapi.enums.CurrencyCode;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private static final Double DOLLAR_VALUE = 0.052;
    private static final Double EUR_VALUE = 0.050;

    private static final EnumMap<CurrencyCode, Double> currenciesMap = new EnumMap<CurrencyCode, Double>(Map.ofEntries(
            Map.entry(CurrencyCode.MXN, 1.0),
            Map.entry(CurrencyCode.USD, DOLLAR_VALUE),
            Map.entry(CurrencyCode.EUR, EUR_VALUE)));

    @Override
    public TotalDescriptive calculateTotalByCurrency(Double value, CurrencyCode currencyCode) {
        TotalDescriptive totalDescriptive = new TotalDescriptive();
        Double newTotalWithCurrency = this.changeCurrencyValueByCode(value,
                currencyCode);
        totalDescriptive.setTotal(newTotalWithCurrency);

        String totalFormatted = this.formatValueByCurrencyCode(newTotalWithCurrency, currencyCode);
        totalDescriptive.setTotalText(totalFormatted);

        return totalDescriptive;
    }

    private Double getCurrencyValueByCode(CurrencyCode currency) {
        return currenciesMap.get(currency);
    }

    @Override
    public String formatValueByCurrencyCode(Double value, CurrencyCode currencyCode) {
        Locale locale = new Locale("es-MX", "MX");

        switch (currencyCode) {
            case USD:
                locale = new Locale("en-US", "US");
                break;
            case EUR:
                locale = new Locale("es-ES", "ES");
                break;
            default:
                break;
        }

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(value);
    }

    private Double changeCurrencyValueByCode(Double value, CurrencyCode currencyCode) {
        Double currencyValue = this.getCurrencyValueByCode(currencyCode);
        return value * currencyValue;
    }

}
