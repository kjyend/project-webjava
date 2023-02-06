package clothes.clothesproject.web.controller;
import clothes.clothesproject.domain.dto.ClothesDto;
import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.dto.WeatherDto;
import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.service.ClothesService;
import clothes.clothesproject.domain.service.WeatherService;
import clothes.clothesproject.web.argumentresolver.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ClothesController {

    private final ClothesService clothesService;
    private final WeatherService weatherService;

    @GetMapping("/clothes")
    public String editForm(@Login MemberDto memberDto, @RequestParam("temp") Long temp,@RequestParam("weatherId") Long id,
                           ClothesDto clothesDto,Model model){
        //service를 통해서 if문으로 비교하고 다른 정보의 db를 저장한다.
        log.info("=={}",temp);
        log.info("111==={}",id);

        clothesService.compareTemp(temp);
        model.addAttribute("clothes", clothesDto);
        return "weather/clothes";
    }
}
