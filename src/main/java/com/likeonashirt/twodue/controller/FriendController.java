package com.likeonashirt.twodue.controller;

import com.likeonashirt.twodue.dto.FriendDTO;
import com.likeonashirt.twodue.model.Friend;
import com.likeonashirt.twodue.service.FriendService;
import com.likeonashirt.twodue.util.Logger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/friends")
    public String showTasks(ModelMap model, HttpSession session) {

        Logger.logTransaction(request);
        String response = "friends response";
        Logger.logRequestResponse(request, response);

        String email = (String) session.getAttribute("email");
        String displayName = (String) session.getAttribute("displayname");

       List<Friend> friendList= friendService.findByUseremail(email);
        model.addAttribute("showEmail", email);
        model.addAttribute("displayName", displayName);
        model.addAttribute("friendList", friendList);

        return "friends";

    }

    @GetMapping("/add-friend")
    public String showAddFriend(Model model) {
        model.addAttribute("friendDTO", new FriendDTO());
        return "add-friend";
    }

    @PostMapping("/add-friend")
    public String addNewFriend(@ModelAttribute("friendDTO") FriendDTO friendDTO, HttpSession session) {
        friendService.requestFriend(friendDTO, (String) session.getAttribute("email"));
        return "redirect:/friends";
    }

    @GetMapping("/delete-friend")
    public String deleteFriend(@RequestParam("id") Long id) {
        friendService.deleteFriend(id);
        return "redirect:/friends";
    }

}