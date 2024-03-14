package br.com.guilherme.gestaodetarefas.task.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateDTO {
    @NotBlank(message = "O Titulo é obrigatório")
    private String title;
    @NotBlank(message = "O Status é obrigatório")
    private String status;
    @NotBlank(message = "A Descrição é obrigatório")
    private String description;
}
