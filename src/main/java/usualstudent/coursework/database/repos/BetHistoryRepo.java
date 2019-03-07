package usualstudent.coursework.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usualstudent.coursework.database.entity.BetHistory;

/**
 * Репозиторий истории битв
 */
@Repository
public interface BetHistoryRepo extends JpaRepository<BetHistory, Long> {


}
