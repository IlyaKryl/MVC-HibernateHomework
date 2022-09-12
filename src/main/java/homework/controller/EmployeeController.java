package homework.controller;

import homework.dto.EmployeeFormDto;
import homework.model.Employee;
import homework.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getAllEmployeeBySortedSalary() {
        List<Employee> list = employeeService.getAllEmployeeBySortedSalary();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/rich")
    public ResponseEntity<List<Employee>> getAllRichBoys() {
        List<Employee> list = employeeService.getOnlyRichBoys();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeFormDto employeeDto) {
        Employee employee = new Employee();
        employee.setFullName(employeeDto.getFullName());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());
        employee.setPositions(employeeDto.getPositions());

        employeeService.createEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
