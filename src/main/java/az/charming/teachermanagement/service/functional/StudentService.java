package az.charming.teachermanagement.service.functional;

import az.charming.teachermanagement.configuration.UrlConfiguration;
import az.charming.teachermanagement.controller.dto.response.StudentResponseDto;
import az.charming.teachermanagement.dto.StudentDto;
import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import az.charming.teachermanagement.service.CoxLazimliClass;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;
    private final UrlConfiguration urlConfiguration;
    private final RestTemplate restTemplate;
    private final CoxLazimliClass coxLazimliClass;

    public StudentService(StudentRepository studentRepository, UrlConfiguration urlConfiguration, RestTemplate restTemplate, CoxLazimliClass coxLazimliClass) {
        this.studentRepository = studentRepository;
        this.urlConfiguration = urlConfiguration;
        this.restTemplate = restTemplate;
        this.coxLazimliClass = coxLazimliClass;
    }

    public void getStudents(){
        ResponseEntity<StudentResponseDto[]> studentsResponseEntity =  restTemplate.getForEntity(urlConfiguration.getStudentsUrl(), StudentResponseDto[].class);
        StudentResponseDto[] students = studentsResponseEntity.getBody();
        for(StudentResponseDto studentResponseDto: students){
            System.out.println(studentResponseDto);
        }
    }

    public void doSomething(StudentDto studentDto){

    }

    public StudentDto findById(Integer id){
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            return StudentDto.instance(optional.get());
        }else{
            return null;
        }
    }

    public List<StudentDto> findAll(String name, String surname,
                                    Integer age, BigDecimal scholarship) {
        List<StudentEntity> list;
        if (isAllEmpty(name, surname, age, scholarship))
            list= studentRepository.findAll();
        else
            list= studentRepository.findByNameOrSurnameOrAgeOrScholarship(name, surname, age, scholarship);

        List<StudentDto> result =new ArrayList<>();
        for(StudentEntity st: list){
            result.add(StudentDto.instance(st));
        }
        return result;
    }

    private static boolean isAllEmpty(Object... objs) {
        for (Object obj : objs) {
            if (obj != null) System.out.println("obj=" + obj.toString());
            if (obj != null && !obj.toString().isEmpty()) return false;
        }
        return true;
    }

    public List<StudentEntity> findByAgeAndName(String name, Integer age) {
        Specification<StudentEntity> specification = new Specification<StudentEntity>() {
            public Predicate toPredicate(Root<StudentEntity> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (name != null && name.trim().length() > 0) {
                    predicates.add(cb.equal(root.get("name"), name));
                }
                if (age != null && age > 0) {
                    predicates.add(cb.equal(root.get("age"), age));
                }

                Predicate[] arr = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(arr));
            }
        };
        return studentRepository.findAll(specification);
    }

    public StudentDto deleteById(Integer id){
        StudentDto studentDto = findById(id);
        studentRepository.deleteById(id);
        return studentDto;
    }

    public void save(StudentDto studentDto){
        studentRepository.save(studentDto.toEntity());
    }

    public void update(StudentDto studentDto){
        if(studentRepository.getOne(studentDto.getId())==null){
            throw new IllegalArgumentException("not found");
        }
        studentRepository.save(studentDto.toEntity());
    }

    public StudentDto findByUsername(String username){
        Optional<StudentEntity> optional = studentRepository.findByUsername(username);
        if(optional.isPresent()){
            return StudentDto.instance(optional.get());
        }else{
            return null;
        }
    }
}
