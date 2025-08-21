package com.todo.desafio_chatgpt.Controller;

import com.todo.desafio_chatgpt.dto.CreateTaskDTO;
import com.todo.desafio_chatgpt.dto.TaskResponseDTO;
import com.todo.desafio_chatgpt.dto.UpdateTaskDTO;
import com.todo.desafio_chatgpt.Service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Lista todas as tarefas",
            description = "Retorna todas as tarefas cadastradas no sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de tarefas retornada com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.getAllTasks());
    }

    @Operation(
            summary = "Buscar tarefa pelo ID",
            description = "Retorna do sistema a tarefa pelo ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tarefa retornada com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    @GetMapping("/{taskID}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable String taskID) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.getTask(taskID));
    }

    @Operation(
            summary = "Cria uma nova tarefa",
            description = "Cria uma nova tarefa e retorna a tarefa criada",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    @PostMapping
    public ResponseEntity<UUID> createTask(@RequestBody CreateTaskDTO taskDTO) {
        return ResponseEntity.created(URI.create("/task/" + taskService.createTask(taskDTO))).build();
    }

    @Operation(
            summary = "Atualiza uma tarefa",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tarefa retornada com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    @PutMapping("/{taskID}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable String taskID, @RequestBody UpdateTaskDTO updateTaskDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.updateTask(taskID, updateTaskDTO));
    }

    @Operation(
            summary = "Deleta uma tarefa",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tarefa retornada com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
            }
    )
    @DeleteMapping("/{taskID}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskID) {
        taskService.deleteTask(taskID);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
