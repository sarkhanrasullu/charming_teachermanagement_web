package az.charming.teachermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginIndex(){
        return "login";
    }

    @GetMapping("/logout")
    public String logoutIndex(){
        return "logout";
    }

}
