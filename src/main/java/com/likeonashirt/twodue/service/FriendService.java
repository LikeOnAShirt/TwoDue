package com.likeonashirt.twodue.service;

import com.likeonashirt.twodue.dto.FriendDTO;
import com.likeonashirt.twodue.model.Friend;
import com.likeonashirt.twodue.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public List<Friend> findByUseremail(String email) {
        return friendRepository.findByUseremail(email);
    }

    public void requestFriend(FriendDTO friendDTO, String email) {

        String friendemail = friendDTO.getFriendemail();
        int friendstatus = 1;

        Friend friend = new Friend();
        friend.setUseremail(email);
        friend.setFriendemail(friendemail);
        friend.setFriendstatus(friendstatus);

        friendRepository.save(friend);

    }

    public void deleteFriend(String friendemail) {

        friendRepository.deleteByFriendemail(friendemail);

    }


}
