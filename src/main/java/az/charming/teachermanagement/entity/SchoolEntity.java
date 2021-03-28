package az.charming.teachermanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="school")
public class SchoolEntity {

    @Id
    private Integer id;
    private String name;

    @OneToMany
    private List<StudentEntity> studentList;

    @OneToOne(mappedBy = "school", cascade = CascadeType.ALL)
    private SchoolAddress address;

    public Integer getId() {
        return id;
    }

    public SchoolEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SchoolEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<StudentEntity> getStudentList() {
        return studentList;
    }

    public SchoolEntity setStudentList(List<StudentEntity> studentList) {
        this.studentList = studentList;
        return this;
    }

    public SchoolAddress getAddress() {
        return address;
    }

    public SchoolEntity setAddress(SchoolAddress address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "SchoolEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
