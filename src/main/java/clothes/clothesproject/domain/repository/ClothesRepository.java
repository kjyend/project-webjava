package clothes.clothesproject.domain.repository;

import clothes.clothesproject.domain.entiry.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, String> {
}
