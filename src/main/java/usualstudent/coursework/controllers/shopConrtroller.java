package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import usualstudent.coursework.database.entity.Shop;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.ShopRepo;

import java.util.List;

/**
 * Created by PsihoZ on 03.11.2018.
 */
@Controller
public class shopConrtroller {
    @Autowired
    ShopRepo shopRepo;

    @GetMapping("/shop")
   // @PreAuthorize("#authUser.getActivationCode() == null")
    public String about(Model model, @AuthenticationPrincipal Users authUser){
     List<Shop> shop = shopRepo.findAll();
        model.addAttribute("user", authUser);
        model.addAttribute("shop", shop);
        return "shop";
    }
}
