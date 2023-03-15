package com.likeonashirt.twodue.controller;

import com.likeonashirt.twodue.dto.LoginDTO;
import com.likeonashirt.twodue.model.User;
import com.likeonashirt.twodue.service.UserService;
import com.likeonashirt.twodue.util.Logger;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        Logger.logTransaction(request);
        String response = "login response";
        Logger.logRequestResponse(request, response);
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("loginDTO") LoginDTO loginDTO, RedirectAttributes redirectAttributes, HttpSession session) {
        User user = userService.getUserByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (user == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid Credentials, please try again");
            return "redirect:/login";
        } else {
            session.setAttribute("email", user.getEmail());
            session.setAttribute("displayname", user.getDisplayName());
            System.out.println("Email set in session: " + user.getEmail());
            System.out.println("DisplayName set in session: " + user.getDisplayName());
            return "redirect:/tasks";
        }

    }

}
