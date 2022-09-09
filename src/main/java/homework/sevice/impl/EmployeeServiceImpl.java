package homework.sevice.impl;

import homework.dao.EmployeeDao;
import homework.model.Employee;
import homework.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        employeeDao.create(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteById(id);
    }
}
