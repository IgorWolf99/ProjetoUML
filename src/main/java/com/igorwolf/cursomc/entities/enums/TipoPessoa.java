package com.igorwolf.cursomc.entities.enums;

public enum TipoPessoa {
    
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TipoPessoa(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }
    public int getCod(){
        return cod;
    }
    public String getDescricao(){
        return descricao;
    }

    // Converter para os valores do enum 
    public static TipoPessoa toEnum(Integer cod){

        if (cod == null){
            return null;
        }

        for (TipoPessoa x : TipoPessoa.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Código Invalido: " + cod);
    }
}
