package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PsihoZ on 03.11.2018.
 */

@Controller
public class RatingController {

    @Autowired
    UserService userService;
    @Autowired
    UsersRepo usersRepo;

    @GetMapping("/rating")
    public String rating(Model model){
        List<Users> users = userService.getAll();
        model.addAttribute("users", users);
        return "rating";
    }

    @PostMapping("/rating")
    public String rating(String username, Model model){
        Users user = usersRepo.findByUsername(username);

        if( username == null){
            model.addAttribute("error", "Please, input username");

        }
        if( user == null){
            model.addAttribute("error", "User not found");
            List<Users> users = userService.getAll();
            model.addAttribute("users", users );
        }
        else{
            List<Users> users = new ArrayList<>();
            users.add(user);
            model.addAttribute("users", users );
        }

       return "rating";
    }
}
