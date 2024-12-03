package com.example.pim_iv.model;

import com.google.gson.annotations.SerializedName;

public class Cadastro {
    @SerializedName("nome_Usuario")
    private String nomeCompleto;
    @SerializedName("email_Usuario")
    private String email;
    @SerializedName("senha_Usuario")
    private String senha;
    @SerializedName("cpfCnpj_Usuario")
    private String cpf_cnpj;


    public Cadastro(String nomeCompleto, String email, String senha, String cpf_cnpj) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }
}
