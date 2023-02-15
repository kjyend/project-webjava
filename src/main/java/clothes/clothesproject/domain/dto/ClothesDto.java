package clothes.clothesproject.domain.dto;


import clothes.clothesproject.domain.entiry.Weather;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClothesDto {

    private String clothe;
    private Weather weather;
}
