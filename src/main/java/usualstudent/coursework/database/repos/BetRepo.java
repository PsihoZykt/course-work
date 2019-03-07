package usualstudent.coursework.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import usualstudent.coursework.database.entity.Bet;

/**
 * Репозиторий ставок
 */
public interface BetRepo extends JpaRepository<Bet, Long> {


}
