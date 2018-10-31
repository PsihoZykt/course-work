package usualstudent.coursework.controllers.service;


import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.Bet;

import java.util.List;

@Service
public interface BetService {

    Bet addBet(Bet bet);

    void removeBet(Bet bet);

    List<Bet> getAll();


    ;
}
