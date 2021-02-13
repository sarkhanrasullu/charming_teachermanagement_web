package az.charming.teachermanagement.repository;

import az.charming.teachermanagement.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    List<StudentEntity> findByNameOrSurnameOrAgeOrScholarship(String name, String surname, Integer age, BigDecimal scholarship);

}
//spring-data

//java persistence api  jpa orm-in java uchun spesifikasiyasidir
//orm - object relational mapping