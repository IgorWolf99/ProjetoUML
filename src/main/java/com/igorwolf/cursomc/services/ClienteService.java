package com.igorwolf.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorwolf.cursomc.entities.Cliente;
import com.igorwolf.cursomc.repositories.ClienteRepository;
import com.igorwolf.cursomc.services.exceptionsService.ObjectNotFoundException;

@Service
public class ClienteService {
    @Autowired
    public ClienteRepository clienteRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
           return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id ));
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
}
