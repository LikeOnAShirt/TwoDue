package com.likeonashirt.twodue.repository;

import com.likeonashirt.twodue.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, String> {
    void deleteByFriendemail(String friendemail);

    List<Friend> findByUseremail(String email);

}
