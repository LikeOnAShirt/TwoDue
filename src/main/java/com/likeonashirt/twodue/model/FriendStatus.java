package com.likeonashirt.twodue.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Friendstatus")
public class FriendStatus {
    @Id
    @Column(name = "fsid")
    private int fsid;
    @Column(name = "status")
    private String status;

}