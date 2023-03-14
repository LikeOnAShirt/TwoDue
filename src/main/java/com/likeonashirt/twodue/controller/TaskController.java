package com.likeonashirt.twodue.controller;

import com.likeonashirt.twodue.dto.TaskDTO;
import com.likeonashirt.twodue.model.Task;
import com.likeonashirt.twodue.repository.TaskRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String showTasks(ModelMap model, HttpSession session) {

        String email = (String) session.getAttribute("email");
        System.out.println("Email retrieved from session: " + email);

        List<Task> taskList = taskRepository.findByTaskassignee(email);
        model.addAttribute("showEmail", email);
        model.addAttribute("taskList", taskList);

        return "tasks";
    }
    @GetMapping("/add-task")
    public String showNewTask(Model model){
        model.addAttribute("taskDTO", new TaskDTO());
        return "add-task";
    }

    @PostMapping("/add-task")
    public String addNewTask(@ModelAttribute("taskDTO") TaskDTO taskDTO, HttpSession session){

        String taskname = taskDTO.getTaskname();
        LocalDateTime duedate = taskDTO.getDuedate();
        int status = 1;
        String taskowner = (String) session.getAttribute("email");
        String taskassignee = (String) session.getAttribute("email");

        Task task = new Task();
        task.setTaskname(taskname);
        task.setDuedate(duedate);
        task.setStatus(status);
        task.setTaskowner(taskowner);
        task.setTaskassignee(taskassignee);
        taskRepository.save(task);

        return "redirect:/tasks";
    }
    @GetMapping("/delete-task")
    public String deleteTask(@RequestParam("id") Long id) {

        taskRepository.deleteById(id);

        return "redirect:/tasks";

    }

    @GetMapping("/update-task")
    public String showUpdateTaskForm(@RequestParam("id") Long id, Model model) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + id));
        model.addAttribute("task", task);
        return "update-task";
    }

    @PostMapping("/update-task")
    public String updateTask(@ModelAttribute Task task) {
        // Fetch the existing task entity from the database
        Task existingTask = taskRepository.findById(task.getTid()).orElse(null);

        // Merge the values from the update form into the entity
        if (task.getTaskname() != null) {
            existingTask.setTaskname(task.getTaskname());
        }
        if (task.getDuedate() != null) {
            existingTask.setDuedate(task.getDuedate());
        }
        if (task.getStatus() != 1) {
            existingTask.setStatus(1);
        }
        if (task.getTaskowner() != null) {
            existingTask.setTaskowner(task.getTaskowner());
        }
        if (task.getTaskassignee() != null) {
            existingTask.setTaskassignee(task.getTaskassignee());
        }

        // Save the merged entity back to the database
        taskRepository.save(existingTask);

        return "redirect:/tasks";
    }


}
