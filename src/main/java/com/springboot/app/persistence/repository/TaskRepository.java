package com.springboot.app.persistence.repository;

import com.springboot.app.persistence.entity.Task;
import com.springboot.app.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //aplicando sprindata jpa
    public List<Task> findAllByTaskStatus(TaskStatus status);

}
