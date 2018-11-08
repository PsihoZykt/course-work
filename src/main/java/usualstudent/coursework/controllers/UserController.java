package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usualstudent.coursework.database.entity.Role;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;

import java.util.Map;

/**
 * Created by PsihoZ on 03.11.2018.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String userList(Model model, @AuthenticationPrincipal Users user) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", user);
        return "userList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable Users user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            Model model,
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") Users user) {

        {
            model.addAttribute("user", user);
            userService.saveUser(user, username, form);

            return "redirect:/user";
        }
    }

    @GetMapping("profile")
    @PreAuthorize("#authUser.getActivationCode() == null")
    public String getProfile(Model model, @AuthenticationPrincipal Users authUser) {
        model.addAttribute("user", authUser);
        return "profile";
    }

    @PostMapping("profile")
    @PreAuthorize("#authUser.getActivationCode() == null")
    public String updateProfile(
            Model model,
            @AuthenticationPrincipal Users authUser,
            @RequestParam String password,
            @RequestParam String email) {
        model.addAttribute("user", authUser);
        userService.updateProfile(authUser, password, email);
        return "redirect:/user/profile";
    }

}
