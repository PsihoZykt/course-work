package usualstudent.coursework.database.service;


import org.springframework.stereotype.Service;
import usualstudent.coursework.database.entity.Bet;

import java.util.List;

@Service
public interface BetService {

    Bet addBet(Bet bet);

    void removeBet(Bet bet);

    List<Bet> getAll();


    ;
}
