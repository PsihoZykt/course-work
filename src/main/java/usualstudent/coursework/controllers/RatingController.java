package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.RatingRepo;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.RatingService;
import usualstudent.coursework.database.service.UserService;

import java.util.Comparator;
import java.util.List;

/**
 * Created by PsihoZ on 03.11.2018.
 */

@Controller
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    UserService userService;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    RatingService ratingService;
    @Autowired
    RatingRepo ratingRepo;

    @RequestMapping
    String rating(@AuthenticationPrincipal Users authUser, Model model) {
        model.addAttribute("user", authUser);
        return "rating";
    }


    @GetMapping("/userList")
    public
    @ResponseBody List<Users> getUserList() {
        List<Users> users = userService.getAll();
        users.sort(new Comparator<Users>() {
            @Override
            public int compare(Users u1, Users u2) {
                if (u1.getRating() < u2.getRating())
                    return 1;
                if (u1.getRating() > u2.getRating())
                    return -1;
                else return 0;
            }
        });
        return users;

    }


    @GetMapping("/getUser")
    public
    @ResponseBody  Users rating(@RequestParam  String username){

    Users user = userService.getByName(username);
        return user;
    }
}
