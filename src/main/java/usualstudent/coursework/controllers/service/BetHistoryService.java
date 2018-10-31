package usualstudent.coursework.controllers.service;

import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.BetHistory;

import java.util.List;

@Service
public interface BetHistoryService {

    BetHistory addBet(BetHistory bet);

    void removeBet(BetHistory bet);

    List<BetHistory> getAll();

}
