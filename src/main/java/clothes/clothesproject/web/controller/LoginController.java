package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.LoginService;
import clothes.clothesproject.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {//로그인+ 회원가입 안됨 걍 회원가입하는데 비워있음
    // 이거 일단 전부 Model로 받아서 확인을해야할거 같다. 그리고 setter없이 저장하기

    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(MemberDto memberDto,Model model){
        model.addAttribute("member",memberDto);
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@Validated MemberDto memberDto, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectULR, HttpServletRequest request){// dto로 바꿔야한다.
        if(bindingResult.hasErrors()){
            return "member/login";
        }
        MemberDto loginMember=loginService.login(memberDto.getLoginId(),memberDto.getPassword());

        if(loginMember==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "member/login";
        }
        HttpSession session=request.getSession();
        session.setAttribute("loginMember",loginMember);
        return "redirect:"+redirectULR;
    }

    @GetMapping("/signup")
    public String signupForm(MemberDto memberDto, Model model){
        model.addAttribute("member",memberDto);
        return "member/signup";
    }

    @PostMapping("/signup")//setter가 없어서 null로 저장된다. setter가 있으면 그냥 저장이 된다. 지금 setter를 안함
    public String save(@Validated MemberDto memberDto, BindingResult bindingResult){//Member > MemberDto로 변경해야함
        if(bindingResult.hasErrors()){
            return "member/signup";
        }
        //회원 확인하고
        memberService.save(memberDto);
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
