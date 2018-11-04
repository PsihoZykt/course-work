package usualstudent.coursework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by PsihoZ on 03.11.2018.
 */
@Controller
public class shopConrtroller {

    @GetMapping("/shop")
    public String shop(Model model){
        return "shop";
    }
}
