package az.charming.teachermanagement.controller;

import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import az.charming.teachermanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @RequestMapping(value = "students", method = {RequestMethod.GET})
    public String index(Model model,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String surname,
                        @RequestParam(required = false) Integer age,
                        @RequestParam(required = false) BigDecimal scholarship
                        ){
        List<StudentEntity> list = studentService.findAll(
                name,
                surname,
                age,
                scholarship
        );
        model.addAttribute("list", list);
        return "students/index";
    }

    @RequestMapping(value = "students/add", method = {RequestMethod.POST})
    public String add(@ModelAttribute StudentEntity studentEntity){
        studentRepository.save(studentEntity);
        return "redirect:/students";
    }

    @RequestMapping(value = "students/update", method = {RequestMethod.POST})
    public String update(@ModelAttribute StudentEntity studentEntity){
        studentRepository.save(studentEntity);
        return "redirect:/students";
    }

    @RequestMapping(value = "students/delete", method = {RequestMethod.POST})
    public String delete(@RequestParam(required = false) Integer id){
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}
