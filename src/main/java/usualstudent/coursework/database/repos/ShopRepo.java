package usualstudent.coursework.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import usualstudent.coursework.database.entity.Shop;

/**
 * Репозиторий магазина
 */
public interface ShopRepo extends JpaRepository<Shop, Long> {

}
