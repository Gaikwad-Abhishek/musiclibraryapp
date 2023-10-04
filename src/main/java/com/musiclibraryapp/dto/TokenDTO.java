package com.musiclibraryapp.dto;

import lombok.Data;

@Data
public class TokenDTO {
    private String token;
    
    public String getToken() {
    	return token;
    }
}
