package model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private long id;
    private String descricao;

    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addDisciplina(Disciplina disciplina) {
        getDisciplinas().add(disciplina);
    }

    public void removeDisciplina(Disciplina disciplina){
        getDisciplinas().remove(disciplina);
    }

    public void addProfessor(Professor professor) {
        getProfessores().add(professor);
    }

    public void removeProfessor
}
