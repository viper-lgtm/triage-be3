package cz.martinvedra.triagebe3.api.csas.controller;

import cz.martinvedra.triagebe3.api.csas.dto.ExchangeRateDto;

import java.util.List;

public interface ExchangeRateController {
    List<ExchangeRateDto> getExchangeRates();
}
