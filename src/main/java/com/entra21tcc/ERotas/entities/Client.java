package com.entra21tcc.ERotas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.entra21tcc.ERotas.entities.CustomMethods.CustomValueFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.firebase.database.annotations.NotNull;

@Entity
@Table(name = "tb_Client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idClient;

    public String name;

    @NotNull
    public String number;
    public String mail;
    public String cpf;

    @Autowired
    public String clientAddress;

    @OneToMany(mappedBy = "user")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = CustomValueFilter.class)
    private List<Order> orders = new ArrayList<>();

    public Client() {
    }

    public Client(Integer idClient, String name, String number, String mail, String cpf, Address clientAddress) {
        this.idClient = idClient;
        this.name = name;
        this.number = number;
        this.mail = mail;
        this.cpf = cpf;
        this.clientAddress = clientAddress.toString();
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((mail == null) ? 0 : mail.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((clientAddress == null) ? 0 : clientAddress.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (idClient == null) {
            if (other.idClient != null)
                return false;
        } else if (!idClient.equals(other.idClient))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        if (mail == null) {
            if (other.mail != null)
                return false;
        } else if (!mail.equals(other.mail))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (clientAddress == null) {
            if (other.clientAddress != null)
                return false;
        } else if (!clientAddress.equals(other.clientAddress))
            return false;
        return true;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
