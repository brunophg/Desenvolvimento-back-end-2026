package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {

    private String matricula;
    private int titulacaoMaxima;

    private List<Curso> cursosLecionados = new ArrayList<>();

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
