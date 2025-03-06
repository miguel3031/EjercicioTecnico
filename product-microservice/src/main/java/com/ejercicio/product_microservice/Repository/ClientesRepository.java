package com.ejercicio.product_microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.product_microservice.Modelo.Cliente;

@Repository //nos premite crear los cruds 
public interface ClientesRepository extends JpaRepository<Cliente, Integer>  {

    
} 
