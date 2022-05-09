package clothes.clothesproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClothesController {
    @GetMapping("/clothes")
    public String clothesForm(){
        return "weather/clothes";
    }
}
