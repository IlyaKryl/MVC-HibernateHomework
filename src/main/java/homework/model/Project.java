package homework.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
@Data
public class Project {

    @Id
    @SequenceGenerator(name = "projects_id_seq", sequenceName = "projects_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_id_seq")
    private int id;

    @Column(name = "project_name")
    private String projectName;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "project_id")
    private List<Employee> employees;

}
