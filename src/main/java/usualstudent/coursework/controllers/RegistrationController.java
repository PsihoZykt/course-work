package usualstudent.coursework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UsersRepo userRepo;
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model, @AuthenticationPrincipal Users authUser) {
        model.addAttribute("user", authUser);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid Users user,
                          BindingResult bindingResult,
                          Model model,
                          @AuthenticationPrincipal Users authUser) {
        System.out.println(user + " " + bindingResult + " "+  model + " " + authUser);
        model.addAttribute("userValid", user);
        model.addAttribute("user", authUser);

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";

        }
        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }

        model.addAttribute("message", "Successful registration. Please activate your account");
        return "login";
    }

    @GetMapping("/activate/{code}")
    public String activate(
                            Model model,
                           @PathVariable String code,
                          @AuthenticationPrincipal Users authUser) {
        model.addAttribute("user", authUser);
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login";
    }

//    @GetMapping("login")
//    public String getLogin(
//            @RequestParam(required = false) String error,
//            Model model,
//            @AuthenticationPrincipal Users authUser) {
//        if (authUser != null && authUser.getActivationCode() != null) {
//            model.addAttribute("message", "activate your account");
//        }
//        if (error != null)
//            model.addAttribute("message", "User not found");
//        model.addAttribute("user", authUser);
//        return "loginPage";
//    }



}