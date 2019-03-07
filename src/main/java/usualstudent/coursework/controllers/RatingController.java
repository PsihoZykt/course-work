package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.RatingRepo;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.RatingService;
import usualstudent.coursework.database.service.UserService;

import java.util.ArrayList;
import java.util.Comparator;
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
    @Autowired
    RatingService ratingService;
    @Autowired
    RatingRepo ratingRepo;
    @GetMapping("/rating")
    //@PreAuthorize("#authUser.getActivationCode() == null")
    public String rating(Model model, @AuthenticationPrincipal Users authUser){
        List<Users> users = userService.getAll();
        users.sort(new Comparator<Users>() {
            @Override
            public int compare(Users u1, Users u2) {
                if(u1.getRating() < u2.getRating())
                    return 1;
                if(u1.getRating() > u2.getRating())
                    return -1;
                else return 0;
            }
        });
        model.addAttribute("users", users);
        model.addAttribute("user", authUser);
        return "rating";
    }

    @PostMapping("/rating")
    //@PreAuthorize("#authUser.getActivationCode() == null")
    public String rating(String username, Model model, @AuthenticationPrincipal Users authUser){
        Users userFromRating = usersRepo.findByUsername(username);
        model.addAttribute("user", authUser);
        if( username == null){
            model.addAttribute("error", "Please, input username");

        }
        if(  userFromRating == null){
            model.addAttribute("error", "User not found");
            List<Users> users = userService.getAll();
            model.addAttribute("users", users );
        }
        else{
            List<Users> users = new ArrayList<>();
            users.add(userFromRating);
            model.addAttribute("users", users );
        }

       return "rating";
    }
}
