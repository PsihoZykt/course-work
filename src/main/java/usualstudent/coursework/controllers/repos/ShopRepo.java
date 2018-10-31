package usualstudent.coursework.controllers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import usualstudent.coursework.controllers.entity.Shop;

/**
 * Репозиторий магазина
 */
public interface ShopRepo extends JpaRepository<Shop, Long> {

}
