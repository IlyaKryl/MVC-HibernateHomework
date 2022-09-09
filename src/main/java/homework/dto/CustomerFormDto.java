package homework.dto;

import homework.model.Project;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CustomerFormDto {
    private String fullName;
    private String company;
    private List<Project> projects;
}
