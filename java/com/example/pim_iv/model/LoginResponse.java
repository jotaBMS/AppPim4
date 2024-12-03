package com.example.pim_iv.model;

public class LoginResponse {

    private String mensage;
    private String email;

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getMensage() {
        return mensage;
    }


}
