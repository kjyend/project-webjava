package clothes.clothesproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class AreaDto {

    private String latitude;//위도 nx
    private String hardness;//경도 ny


}
