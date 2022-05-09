package clothes.clothesproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    @GetMapping("/weather")
    public String weatherForm(){
        return "weather/weather";
    }
}
