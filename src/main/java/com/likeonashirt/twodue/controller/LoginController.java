package com.likeonashirt.twodue.controller;

import com.likeonashirt.twodue.dto.LoginDTO;
import com.likeonashirt.twodue.model.User;
import com.likeonashirt.twodue.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("loginDTO") LoginDTO loginDTO, RedirectAttributes redirectAttributes, HttpSession session) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null || !user.getPassword().equals(loginDTO.getPassword())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid Credentials, please try again");
            return "login";
        } else {
            session.setAttribute("email", user.getEmail());
            System.out.println("Email set in session: " + user.getEmail());
            return "redirect:/tasks";

        }

    }

}

