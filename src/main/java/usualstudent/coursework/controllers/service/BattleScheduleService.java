package usualstudent.coursework.controllers.service;

import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.BattleSchedule;

import java.util.List;

@Service
public interface BattleScheduleService {
    BattleSchedule addBattleSchedule(BattleSchedule battleSchedule);

    void removeBattleSchedule(BattleSchedule battleSchedule);

    BattleSchedule editBattleSchedule(BattleSchedule battleSchedule);

    List<BattleSchedule> getBattleScheduleByDate(BattleSchedule battleSchedule);
}
