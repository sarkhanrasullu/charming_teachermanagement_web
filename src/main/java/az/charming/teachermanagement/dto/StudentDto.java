package az.charming.teachermanagement.dto;

import az.charming.teachermanagement.entity.SchoolEntity;
import az.charming.teachermanagement.entity.StudentEntity;
import az.charming.teachermanagement.entity.TeacherEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StudentDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    private SchoolDto school;
    private List<TeacherDto> teacherList;

    public String defineFullname(){
        return name+" "+surname;
    }

    public StudentEntity toEntity(){
        List<TeacherEntity> teachers = new ArrayList<>();
        if(this.getTeacherList()!=null) {
            for (TeacherDto teacherDto : this.getTeacherList()) {
                teachers.add(new TeacherEntity()
                        .setName(teacherDto.getName())
                        .setId(teacherDto.getId())
                );
            }
        }

        SchoolEntity schoolEntity = null;
        if(this.getSchool()!=null){
            schoolEntity = new SchoolEntity()
                    .setId(this.getSchool().getId())
                    .setName(this.getSchool().getName());
        }

        return new StudentEntity()
                .setAge(this.getAge())
                .setId(this.getId())
                .setName(this.getName())
                .setSurname(this.getSurname())
                .setScholarship(this.getScholarship())
                .setSchool(schoolEntity)
                .setTeacherList(teachers)
                ;
    }

    public static StudentDto instance(StudentEntity st){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(st.getId());
        studentDto.setAge(st.getAge());
        studentDto.setName(st.getName());
        studentDto.setSurname(st.getSurname());
        studentDto.setScholarship(st.getScholarship());

        SchoolDto schoolDto = new SchoolDto();
        if(st.getSchool()!=null) {
            schoolDto.setId(st.getSchool().getId());
            schoolDto.setName(st.getSchool().getName());
        }
        studentDto.setSchool(schoolDto);

        List<TeacherDto> teacherDtos = new ArrayList<>();
        if(st.getTeacherList()!=null) {
            for (TeacherEntity teacher : st.getTeacherList()) {
                TeacherDto teacherDto = new TeacherDto();
                teacherDto.setId(teacher.getId());
                teacherDto.setName(teacher.getName());
                teacherDtos.add(teacherDto);
            }
        }
        studentDto.setTeacherList(teacherDtos);
        return studentDto;
    }

    public Integer getId() {
        return id;
    }

    public StudentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public StudentDto setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public SchoolDto getSchool() {
        return school;
    }

    public StudentDto setSchool(SchoolDto school) {
        this.school = school;
        return this;
    }

    public List<TeacherDto> getTeacherList() {
        return teacherList;
    }

    public StudentDto setTeacherList(List<TeacherDto> teacherList) {
        this.teacherList = teacherList;
        return this;
    }
}
