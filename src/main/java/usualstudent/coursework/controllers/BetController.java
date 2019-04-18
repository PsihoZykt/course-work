package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import usualstudent.coursework.database.entity.Bet;
import usualstudent.coursework.database.service.BetService;
import usualstudent.coursework.database.service.UserService;

import java.util.Date;

/**
 * Created by PsihoZ on 07.03.2019.
 */
@Controller
public class BetController {

    @Autowired
    BetService betService;
    @Autowired
    UserService userService;
    @PostMapping("/bet")
    public void makeBet(@RequestParam  String name,
                        @RequestParam int bet,
                        @RequestParam int coef
                         ){
        Bet newBet = new Bet();
        newBet.setUser(userService.getByName(name));
        newBet.setBetDate(new Date());
        newBet.setBet(bet);
        newBet.setCoef(coef);
        betService.addBet(newBet);
    }


}
