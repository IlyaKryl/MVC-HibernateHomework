package homework.sevice;

import homework.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(int id);
    List<Employee> getAllEmployeeBySortedSalary();
    List<Employee> getOnlyRichBoys();
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
