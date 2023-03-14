package com.likeonashirt.twodue.repository;

import com.likeonashirt.twodue.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskassignee(String email);

}
