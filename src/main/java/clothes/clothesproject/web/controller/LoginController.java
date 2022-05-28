package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.service.LoginService;
import clothes.clothesproject.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("member") MemberDto member){
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("member") MemberDto member, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectULR, HttpServletRequest request){// dto로 바꿔야한다.
        if(bindingResult.hasErrors()){
            return "member/login";
        }
        MemberDto loginMember= (MemberDto) loginService.login(member.getMemberLoginId(),member.getMemberPassword());

        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "member/login";
        }
        HttpSession session=request.getSession();
        session.setAttribute("loginMember",loginMember);
        return "redirect:"+redirectULR;
    }

    @GetMapping("/signup")
    public String signupForm(@ModelAttribute("member") MemberDto member){
        return "member/signup";
    }

    @PostMapping("/signup")
    public String save(@Validated @ModelAttribute MemberDto member, BindingResult bindingResult){//Member > MemberDto로 변경해야함
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
