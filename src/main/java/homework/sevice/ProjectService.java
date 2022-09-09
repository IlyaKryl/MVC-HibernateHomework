package homework.sevice;

import homework.model.Project;

public interface ProjectService {
    Project getProject(int id);
    void createProject(Project project);
    void updateProject(Project project);
    void deleteProject(int id);
}
