package com.todo.desafio_chatgpt.dto;

import com.todo.desafio_chatgpt.dto.Enum.StatusENUM;

public record UpdateTaskDTO(String title, String description, String dateTime, StatusENUM status) {
}
