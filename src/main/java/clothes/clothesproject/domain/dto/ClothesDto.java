package clothes.clothesproject.domain.dto;


import clothes.clothesproject.domain.entiry.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class ClothesDto {

    private String clothe;
    private Weather weather;
}
