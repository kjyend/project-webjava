package clothes.clothesproject.web.controller;
import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.service.ClothesService;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ClothesController {

    private final ClothesService clothesService;

    @GetMapping("/clothes")
    public String editForm(@Login Member loginMember,@ModelAttribute("clothes") Clothes clothes){
        if(loginMember==null){
            return "redirect:/";
        }
        return "member/clothes";
    }

    @PostMapping("/clothes")
    public String edit(@ModelAttribute Clothes clothes){
        log.info("=={}",clothes.getFirstclothes());
        clothesService.save(clothes);
        return "redirect:/clothes";
    }
}
