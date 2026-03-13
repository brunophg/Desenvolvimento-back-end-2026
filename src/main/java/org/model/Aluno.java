package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno extends Pessoa {

    private String matricula;
    private int anoInicio;
    private int semestreInicio;


    private ArrayList<Situacao> situacoes;
    private ArrayList<Diario> diarios;

    public ArrayList<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(ArrayList<Diario> diarios) {
        this.diarios = diarios;
    }


    public ArrayList<Situacao> getSituacoes() {
        if (situacoes == null) {
            situacoes = new ArrayList<>();
        }
        return situacoes;
    }

    public void setSituacoes(ArrayList<Situacao> situacoes) {
        this.situacoes = situacoes;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getSemestreInicio() {
        return semestreInicio;
    }

    public void setSemestreInicio(int semestreInicio) {
        this.semestreInicio = semestreInicio;
    }

    public void addSituacao(Situacao situacao) {
        getSituacoes().add(situacao);
    }

    public void removeSituacao(Situacao situacao) {
        getSituacoes().remove(situacao);
    }

    public void addDiario(Diario diario) {
        getDiarios().add(diario);
    }

    public void removeDiario(Diario diario) {
        getDiarios().remove(diario);
    }


    @Override
    public String toString() {
        return super.toString() + "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", anoInicio=" + anoInicio +
                ", semestreInicio=" + semestreInicio +
                ", situacao=" + situacoes +
                ", diarios=" + diarios +
                '}';
    }
}
