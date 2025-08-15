package com.todo.desafio_chatgpt.dto;

import com.todo.desafio_chatgpt.Entity.Task;
import com.todo.desafio_chatgpt.dto.Enum.StatusENUM;

import java.util.UUID;

public record TaskResponseDTO(UUID id, String title, String description, String dateTime, StatusENUM status) {
    public TaskResponseDTO (Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getDateTime(), task.getStatus());
    }
}
