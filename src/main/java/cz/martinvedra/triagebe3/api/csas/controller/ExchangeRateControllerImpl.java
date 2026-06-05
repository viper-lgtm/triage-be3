package cz.martinvedra.triagebe3.api.csas.controller;

import cz.martinvedra.triagebe3.api.csas.dto.ExchangeRateDto;
import cz.martinvedra.triagebe3.service.csas.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/be3")
@RequiredArgsConstructor
public class ExchangeRateControllerImpl implements ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping
    @Override
    public List<ExchangeRateDto> getExchangeRates() {
        return exchangeRateService.getExchangeRates();
    }
}
