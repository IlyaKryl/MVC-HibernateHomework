package homework.sevice.impl;

import homework.dao.ProjectDao;
import homework.model.Project;
import homework.sevice.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    @Transactional
    public Project getProject(int id) {
        return projectDao.findById(id);
    }

    @Override
    @Transactional
    public void createProject(Project project) {
        projectDao.create(project);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        projectDao.update(project);
    }

    @Override
    @Transactional
    public void deleteProject(int id) {
        projectDao.deleteById(id);
    }
}
