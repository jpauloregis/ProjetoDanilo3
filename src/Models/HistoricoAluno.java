/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;//Aqui ficam todos os nossos metodos get/sets e construtor das classes

/**
 *
 * @author Joao Paulo e Matheus
 */
public class HistoricoAluno {

    private int idturmAluno;
    private String disciplina;
    private int mataluno;
    private int id_turma;
    private double nota1;
    private double nota2;
    private double media;

    public HistoricoAluno(int idturmAluno, String disciplina, int mataluno, int id_turma, double nota1, double nota2, double media) {
        this.idturmAluno = idturmAluno;
        this.disciplina = disciplina;
        this.mataluno = mataluno;
        this.id_turma = id_turma;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
    }

    public int getIdturmAluno() {
        return idturmAluno;
    }

    public void setIdturmAluno(int idturmAluno) {
        this.idturmAluno = idturmAluno;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getMataluno() {
        return mataluno;
    }

    public void setMataluno(int mataluno) {
        this.mataluno = mataluno;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

}
