package clothes.clothesproject.web.controller;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.MemberService;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/edit")
    public String editForm(@Login Member loginMember,@ModelAttribute("member") Member member){
        if(loginMember==null){
            return "redirect:/";
        }
        return "member/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("member") Member member){
//        memberService.save(member);// <>,<>로 받아야 받아야한다.
        return "checkHome";
    }
}
