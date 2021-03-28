package az.charming.teachermanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teacher")
public class TeacherEntity {

    @Id
    private Integer id;
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE
    })
    @JoinTable(name = "student_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> studentList;

    public Integer getId() {
        return id;
    }

    public TeacherEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeacherEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<StudentEntity> getStudentList() {
        return studentList;
    }

    public TeacherEntity setStudentList(List<StudentEntity> studentList) {
        this.studentList = studentList;
        return this;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
