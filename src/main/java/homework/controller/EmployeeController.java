package homework.controller;

import homework.dto.EmployeeFormDto;
import homework.model.Employee;
import homework.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeFormDto employeeDto) {
        Employee employee = new Employee();
        employee.setFullName(employeeDto.getFullName());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());
        employee.setPositions(employeeDto.getPositions());

        employeeService.createEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id,
                                                   @RequestBody EmployeeFormDto employeeDto) {
        Employee employee = employeeService.getEmployee(id);
        employee.setFullName(employeeDto.getFullName());
        employee.setFullName(employeeDto.getFullName());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());
        employee.setPositions(employeeDto.getPositions());

        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
