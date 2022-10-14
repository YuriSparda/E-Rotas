package com.entra21tcc.ERotas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idProduct;

    public String nmProduct;
    public Double valorSeguro;

    @Autowired
    public Address prodAddress;

    public Product(Integer cep, String rua, String estado, String cidade, String bairro, Integer n_Casa,
            String complemento) {
        Address prodAddress=new Address(cep, rua, estado, cidade, bairro, n_Casa, complemento);
        this.prodAddress=prodAddress;
    }

    public Product() {
    }

    public Product(Integer idProduct, String nmProduct, Double valorSeguro) {
        this.idProduct = idProduct;
        this.nmProduct = nmProduct;
        this.valorSeguro = valorSeguro;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
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

    public Address getFronAddress() {
        return prodAddress;
    }

    public void setFronAddress(Address fronAddress) {
        this.prodAddress = fronAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
        result = prime * result + ((nmProduct == null) ? 0 : nmProduct.hashCode());
        result = prime * result + ((valorSeguro == null) ? 0 : valorSeguro.hashCode());
        result = prime * result + ((prodAddress == null) ? 0 : prodAddress.hashCode());
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
        if (prodAddress == null) {
            if (other.prodAddress != null)
                return false;
        } else if (!prodAddress.equals(other.prodAddress))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [fronAddress=" + prodAddress + "]";
    }

}
