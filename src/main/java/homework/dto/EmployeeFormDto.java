package homework.dto;

import homework.model.Position;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EmployeeFormDto {
    private String fullName;
    private int age;
    private double salary;
    private List<Position> positions;
}
