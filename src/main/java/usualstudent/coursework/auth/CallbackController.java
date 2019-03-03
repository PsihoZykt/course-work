package usualstudent.coursework.auth;

import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class CallbackController {
@Autowired
AuthController controller;


    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    protected void getCallback(Model model, final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        try {
            Tokens tokens = controller.handle(req);
            SessionUtils.set(req, "accessToken", tokens.getAccessToken());
            SessionUtils.set(req, "idToken", tokens.getIdToken());

            res.sendRedirect("/");
        } catch (IdentityVerificationException e) {
            res.sendRedirect("/login");
        }
    }

    @RequestMapping(value = "/portal/home", method = RequestMethod.GET)
    protected String home(Model model, final HttpServletRequest req) {
        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken != null) {
            model.addAttribute("userId", accessToken);
        } else if (idToken != null) {
            model.addAttribute("userId", idToken);
        }
        return "main";
    }
}