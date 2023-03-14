package com.likeonashirt.twodue.controller;

import com.likeonashirt.twodue.dto.TaskDTO;
import com.likeonashirt.twodue.model.Task;
import com.likeonashirt.twodue.service.TaskService;
import com.likeonashirt.twodue.util.Logger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/tasks")
    public String showTasks(ModelMap model, HttpSession session) {

        Logger.logTransaction(request);
        String response = "tasks response";
        Logger.logRequestResponse(request, response);

        String email = (String) session.getAttribute("email");
        String displayName = (String) session.getAttribute("displayname");
        System.out.println("Email retrieved from session: " + email);
        System.out.println("DisplayName set in session: " + displayName);

        List<Task> taskList = taskService.findByTaskassignee(email);
        model.addAttribute("showEmail", email);
        model.addAttribute("displayName", displayName);
        model.addAttribute("taskList", taskList);

        return "tasks";
    }

    @GetMapping("/add-task")
    public String showNewTask(Model model) {
        model.addAttribute("taskDTO", new TaskDTO());
        return "add-task";
    }

    @PostMapping("/add-task")
    public String addNewTask(@ModelAttribute("taskDTO") TaskDTO taskDTO, HttpSession session) {
        taskService.saveTask(taskDTO, "email");
        return "redirect:/tasks";
    }

    @GetMapping("/delete-task")
    public String deleteTask(@RequestParam("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/update-task")
    public String showUpdateTaskForm(@RequestParam("id") Long id, Model model) {
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    @PostMapping("/update-task")
    public String updateTask(@ModelAttribute Task task) {
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

}
