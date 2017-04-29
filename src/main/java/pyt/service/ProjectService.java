package pyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pyt.model.Category;
import pyt.model.Comment;
import pyt.model.Project;
import pyt.model.Task;
import pyt.repository.ProjectRepository;

@Service
public class ProjectService extends AbstractService<Project, ProjectRepository> {

    @Autowired
    CategoryService categoryService;

    public Project addComment(Comment comment, Long id) {

        log.info("addComment");

        Project project = repository.findOne(id);
        project.addComment(comment);
        return repository.save(project, 1);
    }

    public Project addCategory(Long id, Long categoryId) {

        log.info("addCategory");

        Category category = categoryService.getById(categoryId);

        Project project = repository.findOne(id);
        project.addCategory(category);
        return repository.save(project, 1);
    }

    public Project addTask(Task task, Long id) {

        log.info("addTask");

        Project project = repository.findOne(id);
        project.addTask(task);
        return repository.save(project, 1);
    }
}
