package br.com.guilherme.gestaodetarefas.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.gestaodetarefas.exceptions.customExceptions.NotFoundException;
import br.com.guilherme.gestaodetarefas.task.dtos.TaskCreateDTO;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity createTask(TaskCreateDTO payload) {
        var newTask = new TaskEntity(payload.getTitle(), payload.getStatus(), payload.getDescription());
        return taskRepository.save(newTask);
    }
    
    public List<TaskEntity> listTasks() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> listTasks(String status) {
        return taskRepository.findByStatus(status);
    }

    public TaskEntity retrieveEntity(String taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException());
    }

    public TaskEntity updateTask(String taskId, TaskCreateDTO payload) {
        var task = taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException());

        if (payload.getTitle() != null) task.setDescription(payload.getTitle());
        if (payload.getStatus() != null) task.setDescription(payload.getStatus());
        if (payload.getDescription() != null) task.setDescription(payload.getDescription());

        return taskRepository.save(task);
    }

    public void deleteTask(String taskId) {
        var task = taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException());

        taskRepository.delete(task);
    }

}