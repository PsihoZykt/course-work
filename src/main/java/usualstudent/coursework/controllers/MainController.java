package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

        model.put("test", "testing Msg");
        return "main";
    }

}
