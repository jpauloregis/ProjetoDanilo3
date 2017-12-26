/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models; //Aqui ficam todos os nossos metodos get/sets e construtor das classes

/**
 *
 * @author Joao Paulo e Matheus
 */
public class AlunoTurma {
    private int IdTurma;
    public int MatAluno;
    public int CodTurma;

    public AlunoTurma(int IdTurma, int MatAluno, int CodTurma) {
        this.IdTurma = IdTurma;
        this.MatAluno = MatAluno;
        this.CodTurma = CodTurma;
    }

    public int getIdTurma() {
        return IdTurma;
    }

    public void setIdTurma(int IdTurma) {
        this.IdTurma = IdTurma;
    }

    public int getMatAluno() {
        return MatAluno;
    }

    public void setMatAluno(int MatAluno) {
        this.MatAluno = MatAluno;
    }

    public int getCodTurma() {
        return CodTurma;
    }

    public void setCodTurma(int CodTurma) {
        this.CodTurma = CodTurma;
    }

    
}
