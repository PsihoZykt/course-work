package usualstudent.coursework.controllers;

import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import usualstudent.coursework.database.entity.Users;
import usualstudent.coursework.database.repos.UsersRepo;
import usualstudent.coursework.database.service.UserService;


@Controller
public class MainController {


    @Autowired
    private UserService usersService;
    @Autowired
    private UsersRepo userRepo;


    /**
     * После логина спринг обращается к этому контроллеру ( пока не знаю почему )
     * поэтому сохраняем в Model пользователя который прошел авторизацию
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String greeting(Model model, @AuthenticationPrincipal Users authUser) {
        model.addAttribute("user", authUser);
        model.addAttribute("message", "test");

        try {

            HttpResponse<String> response = Unirest.post("https://psihozykt-mysite.auth0.com/oauth/token")
                    .header("content-type", "application/json")
                    .body("{\"client_id\":\"HJjhwj4eSOJze38dBz0fsslngbQHrQs6\",\"client_secret\":\"dzau0QlVVLYQMpeXzdp9lI0Vv6IJVSgyIiOMHmDU83di0TUS3-0ZrdUEJrQR6BZV\",\"audience\":\"https://psihozykt-mysite.auth0.com/api/v2/\",\"grant_type\":\"client_credentials\"}")
                    .asString();
            JsonParser jsonParser = new JsonParser();
            System.out.println(response.getBody());
                     String accessToken =    jsonParser.parse(response.getBody()).getAsJsonObject().get("access_token").getAsString();

//            HttpResponse<String> response2 = Unirest.get("http://path_to_your_api/")
//                    .header("authorization", "Bearer "+ accessToken)
//                    .asString();
                HttpResponse<String> response3 = Unirest.get("https://psihozykt-mysite.auth0.com/userinfo")
                        .header("authorization", "Bearer " + accessToken)
                        .asString();
            System.out.println(accessToken);
             //   System.out.println(response2.getBody());
            System.out.println(response3.getBody());



        } catch (UnirestException e) {
                e.printStackTrace();
            }
       return "main";

    }



}
