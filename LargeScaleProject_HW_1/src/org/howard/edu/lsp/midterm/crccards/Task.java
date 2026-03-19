package org.howard.edu.lsp.midterm.crccards;
/**
 * @author Hamid Kabia - 2024-06-01 Help with generative AI
 * Task class represents a task with 3 values:
 * - taskId: unique identifier for the task
 * - description: brief description of the task
 * - status: current status of the task (OPEN, IN_PROGRESS, COMPLETE)
 */
public class Task {
    private final String taskId;
    private final String description;
    private String status;

    /**
     * Constructor to initialize a Task object with taskId and description. Status is set to OPEN by default.
     * @param taskId
     * @param description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * @param status the new status for the task
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    @Override
    /**
     * Returns a string representation of the task.
     * @return the string representation of the task
     */
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
