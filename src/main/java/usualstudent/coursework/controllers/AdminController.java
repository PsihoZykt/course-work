package usualstudent.coursework.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import usualstudent.coursework.CourseWorkApplication;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;

/**
 * Created by PsihoZ on 31.01.2019.
 */
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    private static final Logger logger = LogManager.getLogger(CourseWorkApplication.class);

    @Autowired
    UserService userService;
    @Autowired
    UsersRepo usersRepo;

    @GetMapping("/adminpanel")
    public String banUser(
            Model model,
            @AuthenticationPrincipal Users user) {
        model.addAttribute("user", user);
        logger.warn("in Get method");
        return "ban";

    }

    @PostMapping("/adminpanel")
    public String ban(@RequestParam String name){
        logger.warn("in psot method");
        Users tUser = usersRepo.findByUsername(name);
        userService.banUser(tUser);
        userService.editUser(tUser);
        return "redirect:/user";

    }
}
