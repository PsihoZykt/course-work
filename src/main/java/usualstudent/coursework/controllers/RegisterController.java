package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.service.UsersService;

import java.text.ParseException;


@Controller
public class RegisterController {
    @Autowired
    UsersService usersService;

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, String name, String password) {
        if(usersService.getByName(name) != null && usersService.getByName(name).getUserPassword().toString().equals(password))
        return "main";
        else {
            model.addAttribute("error", "dsa");
            return "login";
        }
    }


    @PostMapping("/register")
    public String register(Model model, String name, String email, String password, String birthDate, String gender) throws ParseException {
          Users user = new Users(name, email, Integer.parseInt(password), birthDate, gender);
        if (usersService.getByName(name) == null)
            usersService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/test";
    }
}
