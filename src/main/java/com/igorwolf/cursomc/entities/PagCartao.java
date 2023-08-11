package com.igorwolf.cursomc.entities;

import com.igorwolf.cursomc.entities.enums.StatusPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagCartao extends Pagamento{
    private static final long serialVersionUID = 1L;
    
    private Integer numParcelas;


    public PagCartao() {}

    public PagCartao(Integer id, StatusPagamento statusPagamento, Pedido pedido, Integer numParcelas) {
        super(id, statusPagamento, pedido);
        this.numParcelas = numParcelas;
    }

    public PagCartao(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }


    public Integer getNumParcelas() {
        return this.numParcelas;
    }

    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }

    
    
}
