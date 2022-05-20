package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.WeatherService;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather") // 일단 값이 나온다. 하지만 html 확인할것
    public String weatherForm(@Login Member loginMember, Model model) throws Exception {
        if (loginMember == null) {
            return "redirect:/";
        }
        model.addAttribute("model",weatherService.jsonString());
        return "weather/weather";
    }
}
