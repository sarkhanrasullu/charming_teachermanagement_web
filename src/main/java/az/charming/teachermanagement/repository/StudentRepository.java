package az.charming.teachermanagement.repository;

import az.charming.teachermanagement.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor {

    Optional<StudentEntity> findByUsername(String username);
    List<StudentEntity> findByNameOrSurnameOrAgeOrScholarship(String name, String surname, Integer age, BigDecimal scholarship);
//    @Query(value = "select s from StudentEntity s where s.school.id=:id and s.age=:age")
//    List<StudentEntity> findAllBySchoolIdAndAge(@Param("id") Integer id, @Param("age") Integer age);
//
//    @Query(nativeQuery = true, value = "select s.* from student s where s.school_id=:id and s.age=:age")
//    List<StudentEntity> findAllBySchoolIdAndAge2(@Param("id") Integer id, @Param("age") Integer age);
//
//    List<StudentEntity> nqFindBySchoolIdAndAge(Integer schoolId, String name);
//
//    List<StudentEntity> findAllByNameOrderByAgeDesc(String name);
}
//spring-data
//java persistence api  jpa orm-in java uchun spesifikasiyasidir
//orm - object relational mapping