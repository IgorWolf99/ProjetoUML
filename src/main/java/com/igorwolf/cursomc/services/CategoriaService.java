package com.igorwolf.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorwolf.cursomc.entities.Categoria;
import com.igorwolf.cursomc.repositories.CategoriaRepository;
import com.igorwolf.cursomc.services.exceptionsService.ObjectNotFoundException;

@Service
public class CategoriaService {
    
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id ));
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

}
