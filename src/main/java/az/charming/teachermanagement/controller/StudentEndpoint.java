package az.charming.teachermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/students")
public class StudentEndpoint {


    @GetMapping("/index1")
    public List<StudentResponseDto> index1(){
        return Collections.singletonList(new StudentResponseDto().setName("test1"));
    }

    @GetMapping("/index2")
    public List<StudentResponseDto> index2(){
        return Collections.singletonList(new StudentResponseDto().setName("test2"));
    }

    @GetMapping("/index3")
    public List<StudentResponseDto> index3(){
        return Collections.singletonList(new StudentResponseDto().setName("test3"));
    }

}
