package com.example.weather_app.controller;

import com.example.weather_app.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;



@Controller
public class WeatherController {
    
    @Value("${api.key}")
    private String API_KEY;

    private final String URL = "http://api.openweathermap.org/data/2.5/weather?";

    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {

        String api_call = URL + "q=" + city + "&appId=" + API_KEY + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();

        WeatherResponse weatherResponse = restTemplate.getForObject(api_call, WeatherResponse.class);

        if(weatherResponse != null) {
            model.addAttribute("city", weatherResponse.getName());
            model.addAttribute("country", weatherResponse.getSys().getCountry());
            model.addAttribute("weatherDescription", weatherResponse.getWeather().get(0).getDescription());
            model.addAttribute("temperature", weatherResponse.getMain().getTemp());
            model.addAttribute("humidity", weatherResponse.getMain().getHumidity());
            model.addAttribute("windSpeed", weatherResponse.getWind().getSpeed());
            String weatherIcon = "wi wi-owm-" + weatherResponse.getWeather().get(0).getId();
            model.addAttribute("weatherIcon", weatherIcon);
        }
        else {
            model.addAttribute("error", "Invalid City");
        }

        return "weather";
    }
    
}
