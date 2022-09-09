package homework.sevice;

import homework.model.Employee;

public interface EmployeeService {
    Employee getEmployee(int id);
    void createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}
