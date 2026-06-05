package cz.martinvedra.triagebe3.client;

import cz.martinvedra.triagebe3.api.csas.dto.ExchangeRateDto;
import cz.martinvedra.triagebe3.config.properties.AppConfigurationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExchangeRateClient {

    private final RestTemplate restTemplate;
    private final AppConfigurationProperties properties;

    public ExchangeRateDto[] getExchangeRateFromApi() {
        String url = properties.csas().baseUrl();
        log.info("Volám CSAS API na URL: {}", url);

        try {
            ExchangeRateDto[] response = restTemplate.getForObject(url, ExchangeRateDto[].class);

            if (response != null) {
                log.info("API úspěšně vrátilo {} záznamů.", response.length);
            } else {
                log.warn("API vrátilo null.");
            }

            return response;
        } catch (Exception e) {
            log.error("Chyba při volání CSAS API: {}", e.getMessage(), e);
            throw e;
        }
    }
}
