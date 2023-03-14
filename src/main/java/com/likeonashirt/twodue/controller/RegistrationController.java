package com.likeonashirt.twodue.controller;

import com.likeonashirt.twodue.dto.RegistrationDTO;
import com.likeonashirt.twodue.model.User;
import com.likeonashirt.twodue.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());
        model.addAttribute("emailExistsError", "");
        model.addAttribute("emailMatchError", "");
        model.addAttribute("passwordMatchError", "");
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("registrationDTO") RegistrationDTO registrationDTO, ModelMap model) {
        String email = registrationDTO.getEmail();
        String firstName = registrationDTO.getFirstName();
        String lastName = registrationDTO.getLastName();
        String displayName = registrationDTO.getDisplayName();
        String password = registrationDTO.getPassword();
        String confirmPassword = registrationDTO.getConfirmPassword();

        //email validation
        if (!email.equals(registrationDTO.getConfirmEmail())) {
            model.addAttribute("emailMatchError", "Your Email address does not match");
            return "registration";
        }

        //password validation
        if (!password.equals(confirmPassword)) {
            model.addAttribute("passwordMatchError", "Your Password does not match");
            return "registration";
        }

        //confirm user does not already exist
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            model.addAttribute("emailExistsError", "This account already exists");
            return "registration";
        }

        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDisplayName(displayName);
        user.setPassword(password);
        userRepository.save(user);

        return "redirect:/login";

    }

}
