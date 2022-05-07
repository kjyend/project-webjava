package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.entiry.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@ModelAttribute("member")Member member){
        if(member==null){
            return "Home";
        }
        return "CheckHome";
    }
}

