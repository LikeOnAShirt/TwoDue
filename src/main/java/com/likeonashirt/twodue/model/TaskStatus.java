package com.likeonashirt.twodue.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Taskstatus")
public class TaskStatus {
    @Id
    @Column(name = "tsid")
    private int tsid;
    @Column(name = "taskstatus")
    private String taskstatus;

}
