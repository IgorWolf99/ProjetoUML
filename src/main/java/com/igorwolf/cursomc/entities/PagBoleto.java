package com.igorwolf.cursomc.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igorwolf.cursomc.entities.enums.StatusPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPagamento;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataVencimento;

    public PagBoleto(){}

    public PagBoleto(Integer id, StatusPagamento statusPagamento, Pedido pedido, Date dataPagamento,
            Date dataVencimento) {
        super(id, statusPagamento, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    
}
