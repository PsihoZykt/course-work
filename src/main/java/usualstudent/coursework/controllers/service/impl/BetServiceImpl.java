package usualstudent.coursework.controllers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.Bet;
import usualstudent.coursework.controllers.repos.BetRepo;
import usualstudent.coursework.controllers.service.BetService;

import java.util.List;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    BetRepo betRepo;

    @Override
    public Bet addBet(Bet bet) {
        return betRepo.saveAndFlush(bet);

    }

    @Override
    public void removeBet(Bet bet) {
        betRepo.delete(bet);
    }

    @Override
    public List<Bet> getAll() {

        return betRepo.findAll();

    }

}
