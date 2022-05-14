package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.web.argumentresolver.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    @GetMapping("/weather")
    public String weatherForm(@Login Weather weather, Model model){
        return "weather/weather";
    }
}
