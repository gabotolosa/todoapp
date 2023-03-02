package com.springboot.app.persistence.repository;

import com.springboot.app.persistence.entity.Task;
import com.springboot.app.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //aplicando sprindata jpa
    public List<Task> findAllByTaskStatus(TaskStatus status);

    //metodo para marcar tarea finalizada
    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED=TRUE WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinish(@Param("id") Long id);

}
