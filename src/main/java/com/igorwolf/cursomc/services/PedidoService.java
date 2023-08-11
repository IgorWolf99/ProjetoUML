package com.igorwolf.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorwolf.cursomc.entities.Pedido;
import com.igorwolf.cursomc.repositories.PedidoRepository;
import com.igorwolf.cursomc.services.exceptionsService.ObjectNotFoundException;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Integer id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
           return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id ));
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }
}
