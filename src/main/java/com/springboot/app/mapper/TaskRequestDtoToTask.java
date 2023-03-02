package com.springboot.app.mapper;

import com.springboot.app.persistence.entity.Task;
import com.springboot.app.persistence.entity.TaskStatus;
import com.springboot.app.service.dto.TaskRequestDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskRequestDtoToTask implements RequestMapper<TaskRequestDto, Task>{
    @Override
    public Task map(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setEta(taskRequestDto.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
