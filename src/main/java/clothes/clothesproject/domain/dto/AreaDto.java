package clothes.clothesproject.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AreaDto {

    private String latitude;//위도 nx
    private String hardness;//경도 ny


}
