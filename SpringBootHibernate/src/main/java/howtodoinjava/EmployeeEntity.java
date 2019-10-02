package howtodoinjava;

import javax.persistence.*;

@Entity
@Table
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="name",nullable = false,length = 256)
    private String Name;


    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
