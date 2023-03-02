package com.springboot.app.controller;
import com.springboot.app.persistence.entity.Task;
import com.springboot.app.persistence.entity.TaskStatus;
import com.springboot.app.service.TaskService;
import com.springboot.app.service.dto.TaskRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public Task createTask(@RequestBody TaskRequestDto taskRequestDto){
        return this.taskService.createTask(taskRequestDto);
    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.findByAllTaskStatus(status);
    }
}
