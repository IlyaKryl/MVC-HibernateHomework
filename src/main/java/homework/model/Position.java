package homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
@Data
public class Position {

    @Id
    @SequenceGenerator(name = "positions_id_seq", sequenceName = "positions_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "positions_id_seq")
    private int id;

    @Column(name = "position_name")
    @Enumerated(EnumType.STRING)
    private EPosition positionName;

    @ManyToMany(mappedBy = "positions", fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JsonIgnore
    private List<Employee> employees;
}
