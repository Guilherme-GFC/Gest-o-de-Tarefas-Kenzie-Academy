package br.com.guilherme.gestaodetarefas.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.guilherme.gestaodetarefas.task.dtos.TaskCreateDTO;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskEntity createTask(@Valid @RequestBody TaskCreateDTO payload) {
        TaskEntity newTask = taskService.createTask(payload);
        
        return newTask;
    }

    @GetMapping
    public List<TaskEntity> listTask(@RequestParam Optional<String> status) {
        if (status.isEmpty()){
            return taskService.listTasks();
        }
        return taskService.listTasks(status.get());
    }

    @GetMapping("/{taskId}")
    public TaskEntity retrievEntity(@PathVariable String taskId) {
        return taskService.retrieveEntity(taskId);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        taskService.deleteTask(taskId); 
    }
}
