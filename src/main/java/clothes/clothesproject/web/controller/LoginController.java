package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired MemberService memberService; //생성자 조회해야한다.

    @GetMapping("/login")
    public String loginForm(){
        return "member/login";
    }
    @PostMapping("/login")
    public String login(){
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupForm(){
        return "member/signup";
    }

    @PostMapping("/signup")
    public String save(@Validated @ModelAttribute Member member, BindingResult bindingResult){//Member > MemberDto로 변경해야함
        if(bindingResult.hasErrors()){
            return "member/signup";
        }
        memberService.save(member);//나중에  memberdto로 받아야한다.
        return "redirect:/";
    }

}
