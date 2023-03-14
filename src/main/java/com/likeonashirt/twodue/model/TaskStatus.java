package com.likeonashirt.twodue.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Taskstatus")
public class TaskStatus {
    @Id
    @Column(name = "tsid")
    private int sid;
    @Column(name = "status")
    private String status;

}
