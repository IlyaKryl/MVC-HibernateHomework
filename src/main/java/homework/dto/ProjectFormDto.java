package homework.dto;

import homework.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProjectFormDto {
    private String projectName;
    private List<Employee> employees;
}
