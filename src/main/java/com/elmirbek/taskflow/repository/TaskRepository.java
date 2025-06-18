package com.elmirbek.taskflow.repository;


import com.elmirbek.taskflow.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    List <Task> findTasksByUser_Username(String username);
}
