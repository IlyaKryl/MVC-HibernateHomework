package homework.sevice;

import homework.model.Employee;
import homework.model.Project;

import java.util.List;

public interface ProjectService {
    Project getProject(int id);
    List<Employee> getAllEmployeesInProject(int id);
    void createProject(Project project);
    void updateProject(Project project);
    void deleteProject(int id);
}
