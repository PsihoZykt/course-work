package usualstudent.coursework.controllers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.BetHistory;
import usualstudent.coursework.controllers.repos.BetHistoryRepo;
import usualstudent.coursework.controllers.service.BetHistoryService;

import java.util.List;

@Service
public class BetHistoryServiceImpl implements BetHistoryService {

    @Autowired
    BetHistoryRepo betHistoryRepo;


    @Override
    public BetHistory addBet(BetHistory bet) {
        return betHistoryRepo.saveAndFlush(bet);
    }

    @Override
    public void removeBet(BetHistory bet) {
        betHistoryRepo.delete(bet);
    }

    @Override
    public List<BetHistory> getAll() {
        return betHistoryRepo.findAll();
    }
}
