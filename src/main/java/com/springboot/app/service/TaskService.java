package com.springboot.app.service;

import com.springboot.app.exceptions.ToDoExceptions;
import com.springboot.app.mapper.TaskRequestDtoToTask;
import com.springboot.app.persistence.entity.Task;
import com.springboot.app.persistence.entity.TaskStatus;
import com.springboot.app.persistence.repository.TaskRepository;
import com.springboot.app.service.dto.TaskRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskRequestDtoToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskRequestDtoToTask mapper) {
        this.repository = taskRepository;
        this.mapper = mapper;
    }

    public Task createTask(TaskRequestDto taskRequestDto){
        Task task = mapper.map(taskRequestDto);
        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findByAllTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found (Tarea no encontrada)", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinish(id);
    }
}
