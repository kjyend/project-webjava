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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AreaController {

    private final AreaService areaService;

    @GetMapping("/area")
    public String clothesForm(@Login MemberDto memberDto, AreaDto area, Model model){
        model.addAttribute("areaDto",area);
        model.addAttribute("memberDto",memberDto);
        return "weather/area";
    }

    @PostMapping("/area")
    public String clothes(MemberDto memberDto, AreaDto area , RedirectAttributes redirectAttributes){//id 값을 받아서 수정?
        areaService.save(area,memberDto);//area 저장을 id로 보고 저장해야한다.
        return "redirect:/";
    }
}
