package usualstudent.coursework.controllers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import usualstudent.coursework.controllers.entity.Bet;

/**
 * Репозиторий ставок
 */
public interface BetRepo extends JpaRepository<Bet, Long> {


}
