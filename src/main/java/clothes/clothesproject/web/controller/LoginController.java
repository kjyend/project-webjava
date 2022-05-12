package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.MemberService;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {

    private final MemberService memberService; //생성자 조회해야한다.

    @Autowired
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("member")Member member){
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("member") Member member){
        return "redirect:";
    }

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member") Member member){
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

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
