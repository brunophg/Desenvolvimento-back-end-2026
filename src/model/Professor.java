package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professor extends Pessoa {

    private String matricula;
    private int titulacaoMaxima;

    private List<Curso> cursosLecionados = new ArrayList<>();

    public Professor() {
    }

    public Professor(String cpf, Date dataNascimento, String email, String endereco, long id, String identidade, String nome, String telefone) {
        super(cpf, dataNascimento, email, endereco, id, identidade, nome, telefone);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTitulacaoMaxima() {
        return titulacaoMaxima;
    }

    public void setTitulacaoMaxima(int titulacaoMaxima) {
        this.titulacaoMaxima = titulacaoMaxima;
    }

    public List<Curso> getCursosLecionados() {
        return cursosLecionados;
    }

    public void setCursosLecionados(List<Curso> cursosLecionados) {
        this.cursosLecionados = cursosLecionados;
    }
}
