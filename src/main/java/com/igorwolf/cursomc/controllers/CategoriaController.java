package com.igorwolf.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorwolf.cursomc.entities.Categoria;
import com.igorwolf.cursomc.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAllCategorias(){
        List<Categoria> all = categoriaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> findItensCategoria(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    
}
