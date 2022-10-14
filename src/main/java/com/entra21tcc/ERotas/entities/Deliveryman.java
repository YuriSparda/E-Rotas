package com.entra21tcc.ERotas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Deliveryman implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idMotorista;

    public String nmMotorista;
    public String placaVeiculo;
    public Integer numero;

    public Deliveryman(){}
    
    public Deliveryman(Integer idMotorista, String nmMotorista, String placaVeiculo, Integer numero) {
        this.idMotorista = idMotorista;
        this.nmMotorista = nmMotorista;
        this.placaVeiculo = placaVeiculo;
        this.numero = numero;
    }

    public Integer getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(Integer idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getNmMotorista() {
        return nmMotorista;
    }

    public void setNmMotorista(String nmMotorista) {
        this.nmMotorista = nmMotorista;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMotorista == null) ? 0 : idMotorista.hashCode());
        result = prime * result + ((nmMotorista == null) ? 0 : nmMotorista.hashCode());
        result = prime * result + ((placaVeiculo == null) ? 0 : placaVeiculo.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Deliveryman other = (Deliveryman) obj;
        if (idMotorista == null) {
            if (other.idMotorista != null)
                return false;
        } else if (!idMotorista.equals(other.idMotorista))
            return false;
        if (nmMotorista == null) {
            if (other.nmMotorista != null)
                return false;
        } else if (!nmMotorista.equals(other.nmMotorista))
            return false;
        if (placaVeiculo == null) {
            if (other.placaVeiculo != null)
                return false;
        } else if (!placaVeiculo.equals(other.placaVeiculo))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
    
}
