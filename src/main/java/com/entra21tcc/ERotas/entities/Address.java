package com.entra21tcc.ERotas.entities;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Address implements Serializable {
    
    public Integer cep;
    public String rua;
    public String estado;
    public String cidade;
    public String bairro;
    public Integer n_Casa;
    public String complemento;

    public Address(Integer cep, String rua, String estado, String cidade, String bairro, Integer n_Casa,
            String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.n_Casa = n_Casa;
        this.complemento = complemento;
    }

    public Address() {
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getN_Casa() {
        return n_Casa;
    }

    public void setN_Casa(Integer n_Casa) {
        this.n_Casa = n_Casa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "estado : " + estado + " cidade : " + cidade + " bairro :"
                + bairro + " Rua : " + rua + " Numero : "
                + n_Casa + " Complemento : " + complemento + "\n CEP :"
                + cep;
    }
}
