package com.likeonashirt.twodue.controller;

import com.likeonashirt.twodue.service.TaskService;
import com.likeonashirt.twodue.util.Logger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/home")
    public String showHome(ModelMap model, HttpSession session) {

        Logger.logTransaction(request);
        String response = "home response";
        Logger.logRequestResponse(request, response);

        String email = (String) session.getAttribute("email");
        String displayName = (String) session.getAttribute("displayname");

        model.addAttribute("showEmail", email);
        model.addAttribute("displayName", displayName);

        return "home";

    }

}