package cz.martinvedra.triagebe3.service.csas;

import cz.martinvedra.triagebe3.api.csas.dto.ExchangeRateDto;

import java.util.List;

public interface ExchangeRateService {

    List<ExchangeRateDto> getExchangeRates();
    void processExchangeRate(ExchangeRateDto rate);
}
