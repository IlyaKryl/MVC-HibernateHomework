package homework.dao;

import homework.model.Employee;
import homework.model.Project;

import java.util.List;

public interface ProjectDao {
    Project findById(int id);
    List<Employee> findAllEmployeesInProjectId(int id);
    void create(Project project);
    void update(Project project);
    void deleteById(int id);
}
