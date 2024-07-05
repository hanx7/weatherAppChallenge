package com.example.WeatherApp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for WeatherController.
 */
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    /**
     * Tests the /weather endpoint with valid latitude and longitude.
     *
     * @throws Exception if the test request fails
     */
    @Test
    public void testGetWeather() throws Exception {
        double lat = -37.8136;
        double lon = 144.9631;
        String expectedResponse = "Sunny with a high of 25°C";

        given(weatherService.getWeather(lat, lon)).willReturn(expectedResponse);

        mockMvc.perform(get("/weather")
                        .param("lat", String.valueOf(lat))
                        .param("lon", String.valueOf(lon))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }

    /**
     * Tests the /weather endpoint with invalid latitude.
     *
     * @throws Exception if the test request fails
     */
    @Test
    public void testInvalidLatitude() throws Exception {
        double invalidLat = 100.0; // Invalid latitude
        double lon = 144.9631;

        mockMvc.perform(get("/weather")
                        .param("lat", String.valueOf(invalidLat))
                        .param("lon", String.valueOf(lon))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error\":\"Latitude must be between -90 and 90\"}"));
    }

    /**
     * Tests the /weather endpoint with invalid longitude.
     *
     * @throws Exception if the test request fails
     */
    @Test
    public void testInvalidLongitude() throws Exception {
        double lat = -37.8136;
        double invalidLon = 200.0; // Invalid longitude

        mockMvc.perform(get("/weather")
                        .param("lat", String.valueOf(lat))
                        .param("lon", String.valueOf(invalidLon))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error\":\"Longitude must be between -180 and 180\"}"));
    }

    /**
     * Tests the /healthcheck endpoint.
     *
     * @throws Exception if the test request fails
     */
    @Test
    public void testHealthCheck() throws Exception {
        mockMvc.perform(get("/healthcheck")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("The application is running."));
    }
}
