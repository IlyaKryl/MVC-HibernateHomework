package homework.dto;

import homework.model.EPosition;
import homework.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PositionFormDto {
    private EPosition positionName;
    private List<Employee> employees;
}
