package homework.model;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Detail about customers")
public class Customer {

    @Id
    @SequenceGenerator(name = "customers_id_seq", sequenceName = "customers_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "company")
    private String company;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "customer_id")
    private List<Project> projects;
}
