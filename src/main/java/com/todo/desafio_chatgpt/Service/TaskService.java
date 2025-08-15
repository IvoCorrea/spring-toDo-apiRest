package com.todo.desafio_chatgpt.Service;

import com.todo.desafio_chatgpt.dto.CreateTaskDTO;
import com.todo.desafio_chatgpt.dto.TaskResponseDTO;
import com.todo.desafio_chatgpt.dto.UpdateTaskDTO;
import com.todo.desafio_chatgpt.Entity.Task;
import com.todo.desafio_chatgpt.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public UUID createTask(CreateTaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setDateTime(taskDTO.dateTime());

        return taskRepository.save(task).getId();
    }

    public TaskResponseDTO getTask(String taskID) {
        Task task = taskRepository.findById(UUID.fromString(taskID))
                .orElseThrow(() -> new RuntimeException("Task not Found"));
        return new TaskResponseDTO(task);
    }

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponseDTO::new)
                .toList();
    }

    public TaskResponseDTO updateTask(String taskID, UpdateTaskDTO updateTaskDTO) {
        Task task = taskRepository.findById(UUID.fromString(taskID))
                .orElseThrow(() -> new IllegalArgumentException("Task not Found"));

        Optional.ofNullable(updateTaskDTO.title())
                .ifPresent(task::setTitle);

        Optional.ofNullable(updateTaskDTO.description())
                .ifPresent(task::setDescription);

        Optional.ofNullable(updateTaskDTO.dateTime())
                .ifPresent(task::setDateTime);

        Optional.ofNullable(updateTaskDTO.status())
                .ifPresent(task::setStatus);

        return new TaskResponseDTO(task);
    }

    public void deleteTask(String taskID) {
        Task task = taskRepository.findById(UUID.fromString(taskID))
                .orElseThrow(() -> new IllegalArgumentException("Task not Found"));

        taskRepository.delete(task);
    }
}
