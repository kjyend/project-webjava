package clothes.clothesproject.domain.repository;


import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.entiry.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    Optional<Area> findByLatitude(String lat);

    Optional<Area> findByMember(Member member);
}
