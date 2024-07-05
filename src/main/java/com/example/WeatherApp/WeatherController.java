package com.example.WeatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling weather and health check requests.
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * Endpoint to get weather information for specific latitude and longitude.
     *
     * @param lat the latitude value
     * @param lon the longitude value
     * @return the weather information as a String
     */
    @GetMapping("/weather")
    public String getWeather(@RequestParam double lat, @RequestParam double lon) {
        validateCoordinates(lat, lon);
        return weatherService.getWeather(lat, lon);
    }

    /**
     * Endpoint to check the health of the application.
     *
     * @return a message indicating the application is running
     */
    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "The application is running.";
    }

    /**
     * Validates the latitude and longitude parameters.
     *
     * @param lat the latitude parameter to validate
     * @param lon the longitude parameter to validate
     * @throws IllegalArgumentException if the coordinates are out of range
     */
    private void validateCoordinates(double lat, double lon) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
    }
}
