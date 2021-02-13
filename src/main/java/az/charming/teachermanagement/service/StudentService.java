package az.charming.teachermanagement.service;

import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> findAll(String name, String surname,
                                       Integer age, BigDecimal scholarship){
        if(isAllEmpty(name, surname, age, scholarship))
            return studentRepository.findAll();
        return studentRepository.findByNameOrSurnameOrAgeOrScholarship(name, surname, age, scholarship);
    }

    private static boolean isAllEmpty(Object... objs){
        for(Object obj: objs){
            if(obj!=null)System.out.println("obj="+obj.toString());
            if(obj!=null && !obj.toString().isEmpty()) return false;
        }
        return true;
    }
}
