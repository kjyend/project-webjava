package clothes.clothesproject.web.controller;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.web.argumentresolver.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/edit")
    public String editForm(@Login Member loginMember, Model model){
        return "member/edit";
    }
//    @PostMapping("/edit")
}
