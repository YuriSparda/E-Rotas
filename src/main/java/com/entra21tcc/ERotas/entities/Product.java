package com.entra21tcc.ERotas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product extends Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idProduct;

    public Address fornAddress;
    public String nmProduct;
    public Double valorSeguro;

    public Product() {
    }

    public Product(Integer idProduct, Address fornAddress, String nmProduct, Double valorSeguro) {
        this.idProduct = idProduct;
        this.fornAddress = fornAddress;
        this.nmProduct = nmProduct;
        this.valorSeguro = valorSeguro;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Address getFornAddress() {
        return fornAddress;
    }

    public void setFornAddress(Address fornAddress) {
        this.fornAddress = fornAddress;
    }

    public String getNmProduct() {
        return nmProduct;
    }

    public void setNmProduct(String nmProduct) {
        this.nmProduct = nmProduct;
    }

    public Double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(Double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
        result = prime * result + ((fornAddress == null) ? 0 : fornAddress.hashCode());
        result = prime * result + ((nmProduct == null) ? 0 : nmProduct.hashCode());
        result = prime * result + ((valorSeguro == null) ? 0 : valorSeguro.hashCode());
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
        Product other = (Product) obj;
        if (idProduct == null) {
            if (other.idProduct != null)
                return false;
        } else if (!idProduct.equals(other.idProduct))
            return false;
        if (fornAddress == null) {
            if (other.fornAddress != null)
                return false;
        } else if (!fornAddress.equals(other.fornAddress))
            return false;
        if (nmProduct == null) {
            if (other.nmProduct != null)
                return false;
        } else if (!nmProduct.equals(other.nmProduct))
            return false;
        if (valorSeguro == null) {
            if (other.valorSeguro != null)
                return false;
        } else if (!valorSeguro.equals(other.valorSeguro))
            return false;
        return true;
    }

}
