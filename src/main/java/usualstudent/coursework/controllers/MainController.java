package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;

import java.util.Map;


@Controller
public class MainController  {
@Autowired
private UserService usersService;
@Autowired
private UsersRepo usersRepo;



    @GetMapping("/")
    public String greeting( Map<String, Object> model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepo.findByUsername(authentication.getName());
        model.put("user", user);
        return "main";
    }

}
