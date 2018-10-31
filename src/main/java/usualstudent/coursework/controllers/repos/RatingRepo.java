package usualstudent.coursework.controllers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import usualstudent.coursework.controllers.entity.Rating;

/**
 * Репозиторий рейтинговой таблицы
 */
public interface RatingRepo extends JpaRepository<Rating, Long> {


}
