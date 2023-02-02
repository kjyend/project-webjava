package clothes.clothesproject.domain.dto;


import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.entiry.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class WeatherDto {

    private Long temp; //온도
    private String pcp;//강수가 있는지
    private String sky;//하늘 상태

}
