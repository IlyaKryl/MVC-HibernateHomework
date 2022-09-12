package homework.dao;

import homework.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(int id);
    void create(Employee employee);
    void update(Employee employee);
    void deleteById(int id);
    List<Employee> getAllEmployeeBySortedSalary();
    List<Employee> getOnlyRichBoys();
}
