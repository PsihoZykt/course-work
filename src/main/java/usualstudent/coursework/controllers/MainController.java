package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;


@Controller
public class MainController {


    @Autowired
    private UserService usersService;
    @Autowired
    private UsersRepo userRepo;


    /**
     * После логина спринг обращается к этому контроллеру ( пока не знаю почему )
     * поэтому сохраняем в Model пользователя который прошел авторизацию
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String greeting(Model model, @AuthenticationPrincipal Users authUser) {
        model.addAttribute("user", authUser);
        model.addAttribute("message", "test");


        return "main";


    }
}