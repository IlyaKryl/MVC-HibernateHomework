package homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @SequenceGenerator(name = "employees_id_seq", sequenceName = "employees_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_id_seq")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private double salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_position",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "position_id", referencedColumnName = "id"))
    @Cascade(CascadeType.SAVE_UPDATE)
//    @JsonIgnore
    private List<Position> positions;

}
