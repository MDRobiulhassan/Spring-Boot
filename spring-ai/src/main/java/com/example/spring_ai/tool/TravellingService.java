package com.example.spring_ai.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class TravellingService {

    @Tool(description = "Get the current weather in a city")
    public String getWeather(@ToolParam(description = "City name for which to get the weather information") String city) {
        return switch (city) {
            case "Dhaka" -> "The current weather in Dhaka is 30°C with clear skies.";
            case "New York" -> "The current weather in New York is 25°C with light rain.";
            case "London" -> "The current weather in London is 20°C with cloudy skies.";
            default -> "Sorry, I don't have weather information for that city.";
        };
    }
}
