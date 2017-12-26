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
public class Disciplina {
    int codigodisc;
    String nome;

    public Disciplina(int codigodisc, String nome) {
        this.nome = nome;
        this.codigodisc = codigodisc;
    }

    public int getCodigodisc() {
        return codigodisc;
    }

    public void setCodigodisc(int codigodisc) {
        this.codigodisc = codigodisc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
