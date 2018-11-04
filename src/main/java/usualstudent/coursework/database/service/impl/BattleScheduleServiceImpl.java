package usualstudent.coursework.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.BattleSchedule;
import usualstudent.coursework.database.repos.BattleScheduleRepo;
import usualstudent.coursework.database.service.BattleScheduleService;

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
        //TODO:Исправить
        return battleScheduleRepo.findAll();
    }

    @Override
    public List<BattleSchedule> getAll() {
        return battleScheduleRepo.findAll();
    }
}
