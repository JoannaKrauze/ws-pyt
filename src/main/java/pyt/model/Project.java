package pyt.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Project implements Serializable {

    @GraphId
    private Long id;
    private String name;
    @Relationship(type = "PROJECT_COMMENT")
    private List<Comment> comments = new LinkedList<>();
    @Relationship(type = "PROJECT_CATEGORY")
    private List<Category> categorys = new LinkedList<>();
    @Relationship(type = "PROJECT_TASK")
    private List<Task> tasks = new LinkedList<>();

    public Project() {
    }

    public Project(Long id, String name, List<Comment> comments, List<Category> categorys, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.categorys = categorys;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addCategory(Category category) {
        categorys.add(category);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}