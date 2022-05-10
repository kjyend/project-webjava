package clothes.clothesproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AreaController {
    @GetMapping("/area")
    public String clothesForm(){
        return "weather/area";
    }
}
