package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno extends Pessoa {

    private String matricula;
    private int anoInicio;
    private int semestreInicio;


    private Situacao situacao;
    private List<Diario> diarios = new ArrayList<>();

    public List<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(List<Diario> diarios) {
        this.diarios = diarios;
    }

    public Aluno() {
    }

    public Aluno(String cpf, Date dataNascimento, String email, String endereco, long id, String identidade, String nome, String telefone, int anoInicio) {
        super(cpf, dataNascimento, email, endereco, id, identidade, nome, telefone);
        this.anoInicio = anoInicio;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
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
}
