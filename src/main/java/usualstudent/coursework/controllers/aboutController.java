package usualstudent.coursework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import usualstudent.coursework.auth.AuthController;
import usualstudent.coursework.database.entity.Users;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by PsihoZ on 03.11.2018.
 */
@Controller
public class aboutController {

    @Autowired
    private AuthController controller;

    @PreAuthorize("#authUser.getActivationCode() == null")
    @GetMapping("/about")
    public String about(Model model, @AuthenticationPrincipal Users authUser){


        model.addAttribute("user", authUser);
        return "about";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    protected String login(final HttpServletRequest req) {
        String redirectUri = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/callback";
        String authorizeUrl = controller.buildAuthorizeUrl(req, redirectUri);
        return "redirect:" + authorizeUrl;
    }



}
