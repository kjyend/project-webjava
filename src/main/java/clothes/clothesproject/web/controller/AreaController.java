package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.dto.AreaDto;
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
import org.springframework.ui.Model;
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

    @GetMapping("/area")
    public String clothesForm(@Login MemberDto loginMember, AreaDto area, Model model){
        model.addAttribute("Area",area);
        return "weather/area";
    }

    @PostMapping("/area")
    public String clothes(AreaDto area ,HttpServletRequest request){//id 값을 받아서 수정?

        HttpSession session = request.getSession();
        areaService.save(area,(Member) session.getAttribute(SessionConst.LOGIN_MEMBER));//area 저장을 id로 보고 저장해야한다.

        return "redirect:/";
    }
}
