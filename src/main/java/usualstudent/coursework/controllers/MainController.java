package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.impl.UsersServiceImpl;

import java.text.ParseException;


@Controller
public class MainController  {
@Autowired
private UsersServiceImpl usersService;
@Autowired
private UsersRepo usersRepo;
@GetMapping("/test")
public String test(Model model){
    return "test";
}
    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model)throws ParseException {

            Users users = new Users("1", "asd", 1, "1111-11-11", "male");
           if(!usersRepo.findAll().contains(users))
             //  usersService.addUser(users);


        model.addAttribute("name", name);
        return "main";
    }

}
