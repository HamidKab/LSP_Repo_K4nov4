package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Hamid Kabia - 2024-06-01 Help with generative AI
 * TaskManager class manages a collection of Task objects, allowing you to:
 * -add tasks
 * -find tasks
 * -get tasks by status
 */
public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a task to the manager. Throws an exception if a task with the same ID already exists.
     * @param task the task to add
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by its ID.
     * @param taskId the ID of the task to find
     * @return the task with the specified ID, or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Gets all tasks with a specific status.
     * @param status the status to filter tasks by
     * @return a list of tasks with the specified status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}
