package com.todo.desafio_chatgpt.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "ToDo API",
        version = "1.0",
        description = "API para gerenciar tarefas",
        contact = @Contact(
                name = "Ivo Corrêa",
                email = "ivoaurelio-05@hotmail.com",
                url = "https://github.com/IvoCorrea"
        )
)
)
public class SwaggerConfig {
}
