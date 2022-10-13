package com.entra21tcc.ERotas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entra21tcc.ERotas.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
