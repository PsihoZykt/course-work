package usualstudent.coursework.database.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usualstudent.coursework.database.entity.BattleSchedule;

/**
 * Репозиторий битв
 */
@Repository
public interface BattleScheduleRepo extends JpaRepository<BattleSchedule, Long> {

}
