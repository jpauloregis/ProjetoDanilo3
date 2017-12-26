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
public class Professor {
    private int matricula;
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
