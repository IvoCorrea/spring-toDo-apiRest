package com.todo.desafio_chatgpt.Controller;

import com.todo.desafio_chatgpt.dto.CreateTaskDTO;
import com.todo.desafio_chatgpt.dto.TaskResponseDTO;
import com.todo.desafio_chatgpt.dto.UpdateTaskDTO;
import com.todo.desafio_chatgpt.Entity.Task;
import com.todo.desafio_chatgpt.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class ToDoController {
    private final TaskService taskService;

    public ToDoController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.getAllTasks());
    }

    @GetMapping("/{taskID}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable String taskID) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.getTask(taskID));
    }

    @PostMapping
    public ResponseEntity<UUID> createTask(@RequestBody CreateTaskDTO taskDTO) {
        return ResponseEntity.created(URI.create("/task/" + taskService.createTask(taskDTO))).build();
    }

    @PutMapping("/{taskID}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable String taskID, @RequestBody UpdateTaskDTO updateTaskDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.updateTask(taskID, updateTaskDTO));
    }

    @DeleteMapping("/{taskID}")
    public void deleteTask(@PathVariable String taskID) {
        taskService.deleteTask(taskID);
    }
}
