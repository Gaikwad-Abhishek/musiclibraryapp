package com.musiclibraryapp.dto;

import lombok.Data;

@Data
public class UserForm {
    private String username;
    private String password;
    private String passwordRepeat;
}
