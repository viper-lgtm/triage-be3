package cz.martinvedra.triagebe3.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;
import cz.martinvedra.triagebe3.api.csas.dto.ExchangeRateDto;
import cz.martinvedra.triagebe3.service.csas.ExchangeRateService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final ObjectMapper mapper;
    private final ExchangeRateService exchangeRateService;

    @PostConstruct
    public void init() {
        log.info("KafkaConsumerService bean created");
    }

    @KafkaListener(topics = "${app.kafka.topic:exchange-rates}", groupId = "${spring.kafka.consumer.group-id:triage-be3-group}")
    public void listen(String message) {
        try {
            ExchangeRateDto rate = mapper.readValue(message, ExchangeRateDto.class);
            log.info("Received rate: {}", rate.shortName());
            exchangeRateService.processExchangeRate(rate);
        } catch (Exception e) {
            log.warn("Failed to parse or process message", e);
        }
    }
}
