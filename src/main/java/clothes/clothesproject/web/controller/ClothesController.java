package clothes.clothesproject.web.controller;
import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.service.ClothesService;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class ClothesController {

    private final ClothesService clothesService;

    @GetMapping("/clothes")
    public String editForm(@Login Member loginMember, @ModelAttribute("clothes") Clothes clothes, Weather weather){
        if(loginMember==null){
            return "redirect:/";
        }
        //데이터를 미리 만들어서 if문으로 비교하고 db에서 옷을 추천하면된다.
        return "weather/clothes";
    }
}
