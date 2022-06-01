package clothes.clothesproject.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private String temp; //온도
    private String pcp;//강수가 있는지
    private String sky;//하늘 상태

}
