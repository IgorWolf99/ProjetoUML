package com.igorwolf.cursomc.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.igorwolf.cursomc.entities.enums.StatusPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  //
public abstract class Pagamento implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id  // O id será o mesmo do pedido, pois o pagamento é referente a um pedido
    private Integer id;
    private Integer statusPagamento;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId //Para garantir que o id seja o mesmo do pedido
    private Pedido pedido;
    
    public Pagamento(){}

    public Pagamento(Integer id, StatusPagamento statusPagamento, Pedido pedido) {
        this.id = id;
        this.statusPagamento = statusPagamento.getCod();
        this.pedido = pedido;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPagamento getStatusPagamento() {
        return StatusPagamento.toEnum(statusPagamento);
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento.getCod();
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
