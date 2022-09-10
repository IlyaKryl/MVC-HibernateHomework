package homework.controller;

import homework.dto.ProjectFormDto;
import homework.model.Employee;
import homework.model.Project;
import homework.sevice.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") int id) {
        Project project = projectService.getProject(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<List<Employee>> getAllEmployeesInProject(@PathVariable("id") int id) {
        List<Employee> list = projectService.getAllEmployeesInProject(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody ProjectFormDto projectDto) {
        Project project = new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setEmployees(project.getEmployees());

        projectService.createProject(project);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") int id,
                                                   @RequestBody ProjectFormDto projectDto) {
        Project project = projectService.getProject(id);
        project.setProjectName(projectDto.getProjectName());
        project.setEmployees(project.getEmployees());

        projectService.updateProject(project);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") int id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
