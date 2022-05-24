package clothes.clothesproject.web.controller;

import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.AreaService;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping("/area")
    public String clothesForm(@Login Member loginMember,@ModelAttribute("area") Area area){
        if(loginMember==null){
            return "redirect:/";
        }
        return "weather/area";
    }

    @PostMapping("/area")
    public String clothes(@ModelAttribute Area area){
        areaService.save(area);
        return "redirect:/";
    }
}
