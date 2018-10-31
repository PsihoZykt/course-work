package usualstudent.coursework.controllers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usualstudent.coursework.controllers.entity.BattleSchedule;

/**
 * Репозиторий битв
 */
@Repository
public interface BattleScheduleRepo extends JpaRepository<BattleSchedule, Long> {

}
