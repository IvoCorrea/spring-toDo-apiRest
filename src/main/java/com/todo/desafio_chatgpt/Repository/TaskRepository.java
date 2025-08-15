package com.todo.desafio_chatgpt.Repository;

import com.todo.desafio_chatgpt.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
