package homework.dao.impl;

import homework.dao.EmployeeDao;
import homework.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void create(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
    }
    @Override
    public List<Employee> getAllEmployeeBySortedSalary() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e order by e.salary desc ", Employee.class).getResultList();
    }

    @Override
    public List<Employee> getOnlyRichBoys() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e where e.age <= 21 and e.salary > 100000",
                Employee.class).getResultList();
    }
}
