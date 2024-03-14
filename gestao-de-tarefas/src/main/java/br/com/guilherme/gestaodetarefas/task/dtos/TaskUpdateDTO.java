package br.com.guilherme.gestaodetarefas.task.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateDTO {
    private String title;
    private String status;
    private String description;
}
