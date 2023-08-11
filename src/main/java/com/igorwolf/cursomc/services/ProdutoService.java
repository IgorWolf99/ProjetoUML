package com.igorwolf.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorwolf.cursomc.entities.Produto;
import com.igorwolf.cursomc.repositories.ProdutoRepository;
import com.igorwolf.cursomc.services.exceptionsService.ObjectNotFoundException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        List<Produto> todos = produtoRepository.findAll();
        return todos;
    }

    public Produto findById(Integer id){
        Optional<Produto> obj = produtoRepository.findById(id);
           return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id ));
    }
}
