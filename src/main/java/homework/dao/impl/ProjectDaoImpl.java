package homework.dao.impl;

import homework.dao.ProjectDao;
import homework.model.Employee;
import homework.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Project findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Project.class, id);
    }

    @Override
    public List<Employee> findAllEmployeesInProjectId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.get(Project.class, id);
        return project.getEmployees();
    }

    @Override
    public void create(Project project) {
        Session session = sessionFactory.getCurrentSession();;
        session.persist(project);
    }

    @Override
    public void update(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(project);
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.get(Project.class, id);;
        session.remove(project);
    }
}
