package org.example;

import org.dao.*;

public class Main {
    public static void main(String[] args) {

        // Inicializa DAOs usados na gravação das entidades.
        EmpresaDao empresaDao = new EmpresaDao();
        NotaDao notaDao = new NotaDao();
        ItemNotaDao itemNotaDao = new ItemNotaDao();
        ParticipanteDao participanteDao = new ParticipanteDao();
        ProdutoDao produtoDao = new ProdutoDao();

        try {

        } finally {

        }
    }
}