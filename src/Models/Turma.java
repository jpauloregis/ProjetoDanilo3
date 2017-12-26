/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;//Aqui ficam todos os nossos metodos get/sets e construtor das classes

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class Turma {
    int codturma;
    int matdisciplina;
    int codprof;

    public Turma(int codturma, int matdisciplina, int codprof) {
        this.codturma = codturma;
        this.matdisciplina = matdisciplina;
        this.codprof = codprof;
    }

    public int getCodturma() {
        return codturma;
    }

    public void setCodturma(int codturma) {
        this.codturma = codturma;
    }

    public int getMatdisciplina() {
        return matdisciplina;
    }

    public void setMatdisciplina(int matdisciplina) {
        this.matdisciplina = matdisciplina;
    }

    public int getCodprof() {
        return codprof;
    }

    public void setCodprof(int codprof) {
        this.codprof = codprof;
    }
}
