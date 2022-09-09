package homework.dao;

import homework.model.Project;

import java.util.List;

public interface ProjectDao {
    Project findById(int id);
    void create(Project project);
    void update(Project project);
    void deleteById(int id);
}
