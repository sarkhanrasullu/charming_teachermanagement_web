package az.charming.teachermanagement.entity;

import javax.persistence.*;

@Entity
@Table(name="school_address")
public class SchoolAddress {

    @Id
    private Integer id;
    private String name;
    @OneToOne
    @JoinColumn(name="school_id")
    private SchoolEntity school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
