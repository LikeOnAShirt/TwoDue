package com.likeonashirt.twodue.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String displayName;

}