package com.entra21tcc.ERotas.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21tcc.ERotas.entities.Product;
import com.entra21tcc.ERotas.repositories.ProductRepository;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository pRepository;

    public List<Product> findAll() {
        return pRepository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> client = pRepository.findById(id);
        return client.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: " + id + ", Tipo: " + Product.class.getName(), null));
    }
}
