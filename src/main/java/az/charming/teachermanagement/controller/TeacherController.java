package az.charming.teachermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teachers")
public class TeacherController {

    @GetMapping
    public String index(){
        return "teachers/index";
    }

}
