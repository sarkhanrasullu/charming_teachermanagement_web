package az.charming.teachermanagement.controller;

import az.charming.teachermanagement.controller.dto.request.StudentRequestDto;
import az.charming.teachermanagement.controller.dto.response.StudentResponseDto;
import az.charming.teachermanagement.dto.StudentDto;
import az.charming.teachermanagement.service.functional.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/students")
public class StudentEndpoint {

    private StudentService studentService;

    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    //    @Autowired
//    private ApplicationContext applicationContext;
//
//    public StudentEndpoint(){
//        studentService = (StudentService) applicationContext.getBean("studentService");
//    }

    @GetMapping(value = "/teststudents")
    public void testStudents() {
        studentService.getStudents();
    }

    @GetMapping
    public List<StudentResponseDto> index(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String surname,
                                  @RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) BigDecimal scholarship
    ){
        List<StudentDto> list = studentService.findAll(
                name,
                surname,
                age,
                scholarship
        );
        List<StudentResponseDto> result =new ArrayList<>();
        for(StudentDto st: list)
            result.add(StudentResponseDto.instance(st));
        return result;
    }

    @GetMapping(value = "/{id}")
    public StudentResponseDto getById(@PathVariable Integer id) {
        return StudentResponseDto.instance(studentService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<StudentResponseDto> deleteById(@PathVariable Integer id) {
        if(studentService.findById(id)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(StudentResponseDto.instance(studentService.deleteById(id)));
    }

    @PostMapping
    public String add(@RequestBody StudentRequestDto studentRequestDto) {
        StudentDto studentDto =  studentRequestDto.toStudentDto();
        studentDto.setUsername(studentRequestDto.getUsername());
        studentDto.setPassword(bCrypt.encode(studentRequestDto.getPassword()));//$aksdjn@#a,sdsdkjn1
        studentService.save(studentDto);
        return "success";
    }

    @PutMapping
    public String update(@RequestBody StudentRequestDto studentRequestDto){
        StudentDto studentDto =  studentRequestDto.toStudentDto();
        studentDto.setUsername(studentRequestDto.getUsername());
        studentDto.setPassword(bCrypt.encode(studentRequestDto.getPassword()));
        studentService.save(studentDto);
        return "success";
    }

    private final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

    @GetMapping(value = "/login")
    public StudentResponseDto login(@RequestParam String username, @RequestParam String password) {
        StudentDto foundStudent = studentService.findByUsername(username);
        if(foundStudent==null)
            throw new IllegalArgumentException("there is no such user");
        if(!bCrypt.matches(password, foundStudent.getPassword()))//12345   --->  $aksdjn@#a,sdsdkjn1
            throw new IllegalArgumentException("password is invalid");
        return StudentResponseDto.instance(foundStudent);
    }
}
