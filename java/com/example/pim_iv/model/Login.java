package com.example.pim_iv.model;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("email")
    private String username;
    @SerializedName("senha")
    private String senha;

    public Login(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

}
