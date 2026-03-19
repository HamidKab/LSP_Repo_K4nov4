https://www.baeldung.com/javadoc: Used to help understand how to craft meaningful javadocs

AI Use:
prompt:
Im trying to build a task manager in java that should
Task	
• store task information
• update task status
• provide task details	
in the current file I put boiler plates for the methods that are required
The toString() method must produce output in the following format:
T1 Write report [OPEN]

Where the above is defined by: taskId description [status]
Valid status values include: OPEN, IN_PROGRESS, COMPLETE.
Status comparisons are case-sensitive.
If setStatus() is called with any value other than the valid status values listed above, the task's status must be set to UNKNOWN.


with this information build a plan to implement this class
response:
## Plan: Implement Task.java

### Context
Task is a simple data class that stores a task ID, description, and status. It must enforce valid status values and produce a specific string format.

### Fields
- `taskId` (String, final) — unique identifier, set at construction
- `description` (String, final) — brief description, set at construction
- `status` (String) — mutable; defaults to `"OPEN"` on construction

### Constructor
`Task(String taskId, String description)` — initialize fields; set `status = "OPEN"`.

### Getters
`getTaskId()`, `getDescription()`, `getStatus()` — return their respective fields.

### `setStatus(String status)`
Validate the input against the three valid values (case-sensitive):
- If `status` is `"OPEN"`, `"IN_PROGRESS"`, or `"COMPLETE"` → assign it.
- Otherwise → set `this.status = "UNKNOWN"`.

```java
public void setStatus(String status) {
    if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
        this.status = status;
    } else {
        this.status = "UNKNOWN";
    }
}
```

### `toString()`
Format: `taskId description [status]`

```java
public String toString() {
    return taskId + " " + description + " [" + status + "]";
}
```

---

prompt:
I am now trying to implement the TaskManager which should
TaskManager
• store tasks
• add new tasks
• find a task by ID
• return tasks by status
and collaborate with Task
Inside the code are public methods that need to be implemented
additional information
getTasksByStatus() must return a List<Task> containing all tasks whose status matches the specified value. This return type does not restrict the internal data structure used by TaskManager.
Duplicate Task Rule: TaskManager must not allow duplicate task IDs. If a task with the same taskId already exists, addTask(Task task) must throw IllegalArgumentException.
Additional behavior: If findTask() cannot locate the requested task ID, it must return null.

response:
## Plan: Implement TaskManager.java

### Context
TaskManager manages a collection of Task objects. It must support adding tasks (with duplicate ID prevention), finding a task by ID, and filtering tasks by status.

### Internal data structure
Use a `HashMap<String, Task>` keyed by `taskId`. This gives O(1) lookup for `findTask()` and duplicate checking in `addTask()`.

```java
private final Map<String, Task> tasks = new HashMap<>();
```

### `addTask(Task task)`
Check for duplicate ID; throw `IllegalArgumentException` if found, otherwise store:

```java
public void addTask(Task task) {
    if (tasks.containsKey(task.getTaskId())) {
        throw new IllegalArgumentException("Duplicate task ID: " + task.getTaskId());
    }
    tasks.put(task.getTaskId(), task);
}
```

### `findTask(String taskId)`
Return the task if found, `null` otherwise (`HashMap.get` returns null for missing keys):

```java
public Task findTask(String taskId) {
    return tasks.get(taskId);
}
```

### `getTasksByStatus(String status)`
Iterate all values and collect matches into an `ArrayList`:

```java
public List<Task> getTasksByStatus(String status) {
    List<Task> result = new ArrayList<>();
    for (Task task : tasks.values()) {
        if (task.getStatus().equals(status)) {
            result.add(task);
        }
    }
    return result;
}
```

### Verification
- Add T1, T2, T3 → `getTasksByStatus("OPEN")` returns T1 and T3 after T2 is set to IN_PROGRESS
- Add T1 again → catches `IllegalArgumentException` and prints "Duplicate task ID detected."
- `findTask("T2")` returns the T2 task object
- `findTask("T99")` returns `null` → prints "Task not found."
