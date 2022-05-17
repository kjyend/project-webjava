package clothes.clothesproject.domain.repository;

import clothes.clothesproject.domain.entiry.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class WeatherRepository implements JpaRepository<Weather,String> {

}
