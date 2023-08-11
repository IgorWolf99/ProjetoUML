package com.igorwolf.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igorwolf.cursomc.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {
    
}