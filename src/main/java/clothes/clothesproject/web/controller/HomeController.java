package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.web.argumentresolver.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@Login MemberDto memberDto, Model model){
        model.addAttribute("member",memberDto);
        if(memberDto==null){
            return "home";
        }
        return "checkHome";
    }
}

