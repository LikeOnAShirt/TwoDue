package com.likeonashirt.twodue.dto;

import lombok.Data;

@Data
public class FriendDTO {
    private long id;
    private String useremail;
    private String friendemail;
    private int friendstatus;

}
