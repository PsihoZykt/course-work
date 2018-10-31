package usualstudent.coursework.database;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @PostMapping("login")
    public String postMapping(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("post", name);
        return "main";
    }
}
