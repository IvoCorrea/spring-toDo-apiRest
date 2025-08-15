package com.todo.desafio_chatgpt.Entity;

import com.todo.desafio_chatgpt.dto.Enum.StatusENUM;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String description;

    @Column(nullable = false)
    private StatusENUM status = StatusENUM.PENDENTE;

    @Column(nullable = false)
    private String dateTime;
}
