package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import usualstudent.coursework.database.entity.BattleSchedule;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.service.BattleScheduleService;

import java.util.List;

/**
 * Created by PsihoZ on 03.11.2018.
 */
@Controller
public class ScheduleController {

    @Autowired
    BattleScheduleService battleScheduleService;

    @GetMapping("/schedule")
    @PreAuthorize("#authUser.getActivationCode() == null")
    public String schedule(Model model , @AuthenticationPrincipal Users authUser){
        List<BattleSchedule> battleScheduleList = battleScheduleService.getAll();
        model.addAttribute("list", battleScheduleList);
        model.addAttribute("user", authUser);
        return "schedule";

    }
}
