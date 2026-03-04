package model;

import java.util.Date;

public class Aluno extends Pessoa {

    private String matricula;
    private int anoInicio;
    private int semestreInicio;


    public Aluno() {
    }

    public Aluno(String cpf, Date dataNascimento, String email, String endereco, long id, String identidade, String nome, String telefone, int anoInicio) {
        super(cpf, dataNascimento, email, endereco, id, identidade, nome, telefone);
        this.anoInicio = anoInicio;
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
