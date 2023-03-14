package com.likeonashirt.twodue.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private long tid;
    private String taskname;
    private LocalDateTime duedate;
    private int status;
    private String taskowner;
    private String taskassignee;
}

