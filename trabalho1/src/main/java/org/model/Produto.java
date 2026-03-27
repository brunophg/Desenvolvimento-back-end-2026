package org.model;

import java.util.ArrayList;

public class Produto {

    private Long id;
    private String codigo;
    private String descricao;

    private ArrayList<ItemNota> itemNotas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<ItemNota> getItemNotas() {
        return itemNotas;
    }

    public void setItemNotas(ArrayList<ItemNota> itemNotas) {
        this.itemNotas = itemNotas;
    }
}
