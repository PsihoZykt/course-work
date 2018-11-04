package usualstudent.coursework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by PsihoZ on 03.11.2018.
 */
@Controller
public class aboutController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
