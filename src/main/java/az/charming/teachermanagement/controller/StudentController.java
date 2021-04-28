package az.charming.teachermanagement.controller;

import az.charming.teachermanagement.dto.StudentDto;
import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import az.charming.teachermanagement.service.CoxLazimliClass;
import az.charming.teachermanagement.service.functional.StudentService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {

    private final CoxLazimliClass coxLazimliClass;
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(CoxLazimliClass coxLazimliClass, StudentRepository studentRepository, StudentService studentService) {
        this.coxLazimliClass = coxLazimliClass;
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping
    public String index(Model model,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
                        ){
        coxLazimliClass.coxlazimliMethod();
        List<StudentDto> list = studentService.findAll(
                name,
                surname,
                age,
                scholarship
        );
        model.addAttribute("list", list);
        return "students/index";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute StudentEntity studentEntity){
        studentRepository.save(studentEntity);
        return "redirect:/students";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute StudentEntity studentEntity){
        studentRepository.save(studentEntity);
        return "redirect:/students";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam(required = false) Integer id){
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

    private final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

    @GetMapping(value = "/login")
    public String login(
            Model model,
            @RequestParam String username, @RequestParam String password) {
        StudentDto foundStudent = studentService.findByUsername(username);
        if(foundStudent==null)
            throw new IllegalArgumentException("there is no such user");
        if(!bCrypt.matches(password, foundStudent.getPassword()))
            throw new IllegalArgumentException("password is invalid");
        model.addAttribute("loggedInStudent", foundStudent);
        return "redirect:/students";
    }
}
