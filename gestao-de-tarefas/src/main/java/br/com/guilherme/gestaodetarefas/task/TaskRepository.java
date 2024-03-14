package br.com.guilherme.gestaodetarefas.task;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TaskRepository extends JpaRepository<TaskEntity, String> {
    List<TaskEntity> findByStatus(String status);
}