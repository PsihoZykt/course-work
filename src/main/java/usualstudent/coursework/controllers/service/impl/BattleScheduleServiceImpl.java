package usualstudent.coursework.controllers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.BattleSchedule;
import usualstudent.coursework.controllers.repos.BattleScheduleRepo;
import usualstudent.coursework.controllers.service.BattleScheduleService;

import java.util.List;

/**
 * Created by PsihoZ on 11.10.2018.
 */
@Service
public class BattleScheduleServiceImpl implements BattleScheduleService {
    @Autowired
    BattleScheduleRepo battleScheduleRepo;


    @Override
    public BattleSchedule addBattleSchedule(BattleSchedule battleSchedule) {
        return battleScheduleRepo.saveAndFlush(battleSchedule);

    }

    @Override
    public void removeBattleSchedule(BattleSchedule battleSchedule) {
        battleScheduleRepo.delete(battleSchedule);

    }

    @Override
    public BattleSchedule editBattleSchedule(BattleSchedule battleSchedule) {
        return battleScheduleRepo.saveAndFlush(battleSchedule);
    }

    @Override
    public List<BattleSchedule> getBattleScheduleByDate(BattleSchedule battleSchedule) {
        return battleScheduleRepo.findAll();
    }
}
