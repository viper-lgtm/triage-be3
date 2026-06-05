package cz.martinvedra.triagebe3.weatherapi.forecast;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ForecastClient {

    private final RestTemplate restTemplate;



    private String createLocationUrl(String lat, String lon) {
        return String.format("https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&lang=cz&appid=3670cdc2cac8a44b06a02c47179a4159", lat, lon);
    }
}
