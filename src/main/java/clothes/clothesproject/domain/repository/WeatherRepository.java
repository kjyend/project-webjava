package clothes.clothesproject.domain.repository;

import clothes.clothesproject.domain.entiry.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather,Long> {

}
