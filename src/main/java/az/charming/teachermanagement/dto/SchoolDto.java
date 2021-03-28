package az.charming.teachermanagement.dto;

public class SchoolDto {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public SchoolDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SchoolDto setName(String name) {
        this.name = name;
        return this;
    }
}
