package question5_task_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import question5_task_api.Task;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    // In-memory task list
    private List<Task> tasks = new ArrayList<>();

    // Constructor - Initialize with sample tasks
    public TaskController() {
        tasks.add(new Task(1L, "Complete Spring Boot Assignment", "Finish all 5 questions of the assignment", false, "HIGH", "2024-03-15"));
        tasks.add(new Task(2L, "Buy groceries", "Milk, eggs, bread, and fruits", false, "MEDIUM", "2024-03-10"));
        tasks.add(new Task(3L, "Schedule dentist appointment", "Call clinic and book appointment", true, "LOW", "2024-03-05"));
        tasks.add(new Task(4L, "Prepare for exam", "Study chapters 1-5 for final exam", false, "HIGH", "2024-03-20"));
        tasks.add(new Task(5L, "Clean room", "Organize desk and vacuum floor", false, "LOW", "2024-03-12"));
        tasks.add(new Task(6L, "Submit project proposal", "Email project proposal to professor", true, "HIGH", "2024-03-01"));
        tasks.add(new Task(7L, "Exercise", "Go for a 30-minute run", false, "MEDIUM", "2024-03-08"));
    }

    // GET /api/tasks - Get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // GET /api/tasks/{taskId} - Get task by ID
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return new ResponseEntity<>(task, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // GET /api/tasks/status?completed={true/false} - Get tasks by completion status
    @GetMapping("/status")
    public ResponseEntity<List<Task>> getTasksByStatus(@RequestParam boolean completed) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                result.add(task);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // GET /api/tasks/priority/{priority} - Get tasks by priority
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable String priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                result.add(task);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // POST /api/tasks - Create new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        tasks.add(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    // PUT /api/tasks/{taskId} - Update task
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskId().equals(taskId)) {
                updatedTask.setTaskId(taskId); // Keep the same ID
                tasks.set(i, updatedTask);
                return new ResponseEntity<>(updatedTask, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PATCH /api/tasks/{taskId}/complete - Mark task as completed
    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setCompleted(true);
                return new ResponseEntity<>(task, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /api/tasks/{taskId} - Delete task
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                tasks.remove(task);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}