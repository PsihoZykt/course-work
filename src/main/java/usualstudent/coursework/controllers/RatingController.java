package usualstudent.coursework.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.RatingRepo;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.RatingService;
import usualstudent.coursework.database.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PsihoZ on 03.11.2018.
 */

@Controller
public class RatingController {

    @Autowired
    UserService userService;
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    RatingService ratingService;
    @Autowired
    RatingRepo ratingRepo;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/rating")
    //@PreAuthorize("#authUser.getActivationCode() == null")
    public String rating(Model model, Principal principal) throws UnirestException {
        List<Users> users = userService.getAll();
        users.sort((u1, u2) -> {
            if(u1.getRating() < u2.getRating())
                return 1;
            if(u1.getRating() > u2.getRating())
                return -1;
            else return 0;
        });
        HttpResponse<String> response = Unirest.get("https://psihozykt-mysite.auth0.com/api/v2/users/" + principal.getName())
                .header("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6Ik5EQkRSa1U1T0RjeE5EazVPREpHUVRSRk9VVTJNMFV3TVRjeE9VWTJNa1ZDUWpRNU5ETTNPQSJ9.eyJpc3MiOiJodHRwczovL3BzaWhvenlrdC1teXNpdGUuYXV0aDAuY29tLyIsInN1YiI6Imx3M3FXRGxNcU1rYldBSWVOVEZpZGo1Q3N6M1I5a1o0QGNsaWVudHMiLCJhdWQiOiJodHRwczovL3BzaWhvenlrdC1teXNpdGUuYXV0aDAuY29tL2FwaS92Mi8iLCJpYXQiOjE1NTE5NTg5NTUsImV4cCI6MTU1NDU1MDk1NSwiYXpwIjoibHczcVdEbE1xTWtiV0FJZU5URmlkajVDc3ozUjlrWjQiLCJzY29wZSI6InJlYWQ6Y2xpZW50X2dyYW50cyBjcmVhdGU6Y2xpZW50X2dyYW50cyBkZWxldGU6Y2xpZW50X2dyYW50cyB1cGRhdGU6Y2xpZW50X2dyYW50cyByZWFkOnVzZXJzIHVwZGF0ZTp1c2VycyBkZWxldGU6dXNlcnMgY3JlYXRlOnVzZXJzIHJlYWQ6dXNlcnNfYXBwX21ldGFkYXRhIHVwZGF0ZTp1c2Vyc19hcHBfbWV0YWRhdGEgZGVsZXRlOnVzZXJzX2FwcF9tZXRhZGF0YSBjcmVhdGU6dXNlcnNfYXBwX21ldGFkYXRhIGNyZWF0ZTp1c2VyX3RpY2tldHMgcmVhZDpjbGllbnRzIHVwZGF0ZTpjbGllbnRzIGRlbGV0ZTpjbGllbnRzIGNyZWF0ZTpjbGllbnRzIHJlYWQ6Y2xpZW50X2tleXMgdXBkYXRlOmNsaWVudF9rZXlzIGRlbGV0ZTpjbGllbnRfa2V5cyBjcmVhdGU6Y2xpZW50X2tleXMgcmVhZDpjb25uZWN0aW9ucyB1cGRhdGU6Y29ubmVjdGlvbnMgZGVsZXRlOmNvbm5lY3Rpb25zIGNyZWF0ZTpjb25uZWN0aW9ucyByZWFkOnJlc291cmNlX3NlcnZlcnMgdXBkYXRlOnJlc291cmNlX3NlcnZlcnMgZGVsZXRlOnJlc291cmNlX3NlcnZlcnMgY3JlYXRlOnJlc291cmNlX3NlcnZlcnMgcmVhZDpkZXZpY2VfY3JlZGVudGlhbHMgdXBkYXRlOmRldmljZV9jcmVkZW50aWFscyBkZWxldGU6ZGV2aWNlX2NyZWRlbnRpYWxzIGNyZWF0ZTpkZXZpY2VfY3JlZGVudGlhbHMgcmVhZDpydWxlcyB1cGRhdGU6cnVsZXMgZGVsZXRlOnJ1bGVzIGNyZWF0ZTpydWxlcyByZWFkOnJ1bGVzX2NvbmZpZ3MgdXBkYXRlOnJ1bGVzX2NvbmZpZ3MgZGVsZXRlOnJ1bGVzX2NvbmZpZ3MgcmVhZDplbWFpbF9wcm92aWRlciB1cGRhdGU6ZW1haWxfcHJvdmlkZXIgZGVsZXRlOmVtYWlsX3Byb3ZpZGVyIGNyZWF0ZTplbWFpbF9wcm92aWRlciBibGFja2xpc3Q6dG9rZW5zIHJlYWQ6c3RhdHMgcmVhZDp0ZW5hbnRfc2V0dGluZ3MgdXBkYXRlOnRlbmFudF9zZXR0aW5ncyByZWFkOmxvZ3MgcmVhZDpzaGllbGRzIGNyZWF0ZTpzaGllbGRzIGRlbGV0ZTpzaGllbGRzIHJlYWQ6YW5vbWFseV9ibG9ja3MgZGVsZXRlOmFub21hbHlfYmxvY2tzIHVwZGF0ZTp0cmlnZ2VycyByZWFkOnRyaWdnZXJzIHJlYWQ6Z3JhbnRzIGRlbGV0ZTpncmFudHMgcmVhZDpndWFyZGlhbl9mYWN0b3JzIHVwZGF0ZTpndWFyZGlhbl9mYWN0b3JzIHJlYWQ6Z3VhcmRpYW5fZW5yb2xsbWVudHMgZGVsZXRlOmd1YXJkaWFuX2Vucm9sbG1lbnRzIGNyZWF0ZTpndWFyZGlhbl9lbnJvbGxtZW50X3RpY2tldHMgcmVhZDp1c2VyX2lkcF90b2tlbnMgY3JlYXRlOnBhc3N3b3Jkc19jaGVja2luZ19qb2IgZGVsZXRlOnBhc3N3b3Jkc19jaGVja2luZ19qb2IgcmVhZDpjdXN0b21fZG9tYWlucyBkZWxldGU6Y3VzdG9tX2RvbWFpbnMgY3JlYXRlOmN1c3RvbV9kb21haW5zIHJlYWQ6ZW1haWxfdGVtcGxhdGVzIGNyZWF0ZTplbWFpbF90ZW1wbGF0ZXMgdXBkYXRlOmVtYWlsX3RlbXBsYXRlcyByZWFkOm1mYV9wb2xpY2llcyB1cGRhdGU6bWZhX3BvbGljaWVzIHJlYWQ6cm9sZXMgY3JlYXRlOnJvbGVzIGRlbGV0ZTpyb2xlcyB1cGRhdGU6cm9sZXMiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.JXQUkV63l7oWK-JPjDQ2nmFv_RloQm7tsHI1ClzWXX3eeYeHcImh_xnNjJMMI4oinEl1Y7bzgFnjluSrNCMnyutP5QU6KUWKRTaqF0yAzlKKrSXYORpcHjOT7NN2R1GrkcA_JdKpR5RDhCloOglkDbPUNbKLMkdGRz3vSYJKtbf9D7qVCciS6whrQufmxsxwaVeu_FsuRVh-T1w1Twea5VVGFvK5a96UgF6lJGk2kJXVvgkdS9xzXSv02E9BWxaAebIT9vTx2kDlpytpx_pBkYAFRH53QOeS3D-GghvJzywSITxFVXBmx7TCMjllQ6UisZIHaXlgtTIOYycb6F3EaA")
                .asString();
        //logger.info(principal.getName());
        JSONObject jsonObject = new JSONObject(response.getBody());
        String name = jsonObject.get("nickname").toString();
        String email = jsonObject.get("email").toString();
        logger.info(name + " visited rating Page");
        model.addAttribute("user", name);
        model.addAttribute("users", users);
        model.addAttribute("userProfile", usersRepo.findByUsername(name));
        return "rating";
    }

    @PostMapping("/rating")
    //@PreAuthorize("#authUser.getActivationCode() == null")
    public String rating(String username, Model model, @AuthenticationPrincipal Users authUser){
        Users userFromRating = usersRepo.findByUsername(username);
        model.addAttribute("user", authUser);
        if( username == null){
            model.addAttribute("error", "Please, input username");

        }
        if(  userFromRating == null){
            model.addAttribute("error", "User not found");
            List<Users> users = userService.getAll();
            model.addAttribute("users", users );
        }
        else{
            List<Users> users = new ArrayList<>();
            users.add(userFromRating);
            model.addAttribute("users", users );
        }


       return "rating";
    }
}
