package clothes.clothesproject.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/edit")
    public String editForm(){
        return "member/edit";
    }
//    @PostMapping("/edit")
}
