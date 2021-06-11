package az.charming.teachermanagement.controller;

import java.math.BigDecimal;

public class StudentResponseDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;

    public Integer getId() {
        return id;
    }

    public StudentResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentResponseDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentResponseDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public StudentResponseDto setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
        return this;
    }
}
