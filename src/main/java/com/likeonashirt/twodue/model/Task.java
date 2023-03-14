package com.likeonashirt.twodue.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Getter
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private long tid;
    @Column(name = "taskname")
    private String taskname;
    @Column(name = "taskdetails")
    private String taskdetails;
    @Column(name = "duedate")
    private LocalDateTime duedate;
    @Column(name = "repeats")
    private Boolean repeats;
    @Column(name = "repeatvalue")
    private Time repeatValue;
    @Column(name = "status")
    private int status;
    @Column(name = "taskowner")
    private String taskowner;
    @Column(name = "taskassignee")
    private String taskassignee;

}