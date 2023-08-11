package com.igorwolf.cursomc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igorwolf.cursomc.entities.Cliente;
import com.igorwolf.cursomc.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAllClientes(){
        List<Cliente> listClientes = clienteService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listClientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable Integer id){
        Cliente result = clienteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
}
