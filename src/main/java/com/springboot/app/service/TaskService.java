package com.springboot.app.service;

import com.springboot.app.mapper.TaskRequestDtoToTask;
import com.springboot.app.persistence.entity.Task;
import com.springboot.app.persistence.repository.TaskRepository;
import com.springboot.app.service.dto.TaskRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

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
}