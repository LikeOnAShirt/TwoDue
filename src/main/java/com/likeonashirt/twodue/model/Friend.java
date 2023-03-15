package com.likeonashirt.twodue.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "useremail")
    private String useremail;
    @Column(name = "friendemail")
    private String friendemail;
    @Column(name = "friendstatus")
    private int friendstatus;

}
