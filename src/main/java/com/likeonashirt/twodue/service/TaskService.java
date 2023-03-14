package com.likeonashirt.twodue.service;

import com.likeonashirt.twodue.dto.TaskDTO;
import com.likeonashirt.twodue.model.Task;
import com.likeonashirt.twodue.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findByTaskassignee(String email) {
        return taskRepository.findByTaskassignee(email);
    }

    public void saveTask(TaskDTO taskDTO, String email) {
        String taskname = taskDTO.getTaskname();
        LocalDateTime duedate = taskDTO.getDuedate();
        int status = 1;
        String taskowner = email;
        String taskassignee = email;

        Task task = new Task();
        task.setTaskname(taskname);
        task.setDuedate(duedate);
        task.setStatus(status);
        task.setTaskowner(taskowner);
        task.setTaskassignee(taskassignee);
        taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + id));
    }

    public void updateTask(Task updatedTask) {
        Task existingTask = taskRepository.findById(updatedTask.getTid()).orElse(null);
        if (updatedTask.getTaskname() != null) {
            existingTask.setTaskname(updatedTask.getTaskname());
        }
        if (updatedTask.getDuedate() != null) {
            existingTask.setDuedate(updatedTask.getDuedate());
        }
        if (updatedTask.getStatus() != 1) {
            existingTask.setStatus(1);
        }
        if (updatedTask.getTaskowner() != null) {
            existingTask.setTaskowner(updatedTask.getTaskowner());
        }
        if (updatedTask.getTaskassignee() != null) {
            existingTask.setTaskassignee(updatedTask.getTaskassignee());
        }
        taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
