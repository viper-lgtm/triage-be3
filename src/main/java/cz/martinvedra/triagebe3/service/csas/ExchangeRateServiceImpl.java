package cz.martinvedra.triagebe3.service.csas;

import cz.martinvedra.triagebe3.api.csas.dto.ExchangeRateDto;
import cz.martinvedra.triagebe3.client.ExchangeRateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateClient client;

    @Override
    public List<ExchangeRateDto> getExchangeRates() {
        return List.of(client.getExchangeRateFromApi());
    }

    @Override
    public void processExchangeRate(ExchangeRateDto rate) {
        // Simple processing for now: log or extend with persistence/business logic
        System.out.println("Processing rate in service: " + rate.shortName());
    }
}
