package com.yiwentong.dto;


public class TokenResponseDTO {

    public TokenResponseDTO(String token) {
        this.token = token;
    }

    public TokenResponseDTO() {
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
