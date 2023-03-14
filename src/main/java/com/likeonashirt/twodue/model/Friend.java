package com.likeonashirt.twodue.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Friend")
public class Friend {
    @Id
    @Column(name = "useremail")
    private String useremail;
    @Column(name = "friendemail")
    private String friendemail;
    @Column(name = "friendstatus")
    private int friendstatus;

}
