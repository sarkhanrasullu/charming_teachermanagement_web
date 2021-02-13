package az.charming.teachermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity(name="student")//hibernate, eclipselink
public class StudentEntity {

    @Id
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    public Integer getId() {
        return id;
    }

    public StudentEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public StudentEntity setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", scholarship=" + scholarship +
                '}';
    }
}
