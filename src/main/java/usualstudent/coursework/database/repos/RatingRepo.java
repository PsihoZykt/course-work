package usualstudent.coursework.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import usualstudent.coursework.database.entity.Rating;

/**
 * Репозиторий рейтинговой таблицы
 */
public interface RatingRepo extends JpaRepository<Rating, Long> {


}
