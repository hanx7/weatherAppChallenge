package com.example.WeatherApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Service for fetching weather information from the OpenWeatherMap API.
 */
@Service
public class WeatherService {

    private final String BASE_URL = "https://api.openweathermap.org/data/3.0/onecall";

    @Value("${weather.api.key}")
    private String apiKey;

    /**
     * Retrieves weather information for the specified latitude and longitude.
     *
     * @param lat the latitude
     * @param lon the longitude
     * @return the weather information as a String
     * @throws LocationNotFoundException if the location is not found
     */
    public String getWeather(double lat, double lon) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?lat=%s&lon=%s&appid=%s", BASE_URL, lat, lon, apiKey);
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                throw new LocationNotFoundException("Location not found: lat=" + lat + ", lon=" + lon);
            } else {
                throw e;
            }
        }
    }
}
