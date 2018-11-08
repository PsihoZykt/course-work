package usualstudent.coursework.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import usualstudent.coursework.database.entity.Users;

/**
 * Created by PsihoZ on 03.11.2018.
 */
@Controller
public class shopConrtroller {

    @GetMapping("/shop")
    @PreAuthorize("#authUser.getActivationCode() == null")
    public String about(Model model, @AuthenticationPrincipal Users authUser){
        model.addAttribute("user", authUser);
        return "shop";
    }
}
