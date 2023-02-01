package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.AreaService;
import clothes.clothesproject.domain.service.MemberService;
import clothes.clothesproject.web.SessionConst;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AreaController {

    private final AreaService areaService;
    private final MemberService memberService;

    @GetMapping("/area")
    public String clothesForm(@Login MemberDto loginMember, @ModelAttribute("area") Area area){
        return "weather/area";
    }

    @PostMapping("/area")
    public String clothes(@ModelAttribute Area area ,HttpServletRequest request){//id 값을 받아서 수정?

        HttpSession session = request.getSession();

        String check = memberService.listCheck((Member) session.getAttribute(SessionConst.LOGIN_MEMBER));

        if(check.equals("true")) {//member안에 area값이 있다.
            areaService.changeArea((Member) session.getAttribute(SessionConst.LOGIN_MEMBER),area);
        } else{//member안에 area값이 없다.
            areaService.save(area);//area 저장을 id로 보고 저장해야한다.
            memberService.saveArea((Member) session.getAttribute(SessionConst.LOGIN_MEMBER), area);//session값으로 보내줘서 해야한다.
        }

        return "redirect:/";
    }
}
