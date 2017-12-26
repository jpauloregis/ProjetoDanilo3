/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Aluno;
import java.util.ArrayList;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class AlunoController implements Controller {

    ArrayList<Aluno> aluno = new ArrayList();

    public ArrayList<Aluno> index() {
        return this.aluno;
    }

    @Override
    public void store(String[] dados) {// Salva/Guarda o aluno
        Aluno model = new Aluno(Integer.valueOf(dados[0]), dados[1].toUpperCase());
        aluno.add(model);
        System.out.println("---------------------------------");
        System.out.println("Aluno Salvo Com Sucesso");
    }

    @Override
    public void show() { //mostra o aluno salvo
        for (int i = 0; i < aluno.size(); i++) {
            System.out.println(aluno.get(i).getMatricula()+ ": " + aluno.get(i).getNome());
        }
    }

    @Override
    public void update(String[] dados, int id) { //atualiza os dados de aluno
        aluno.get(id).setMatricula(Integer.valueOf(dados[0]));
        aluno.get(id).setNome(dados[1].toUpperCase());
    }

    @Override
    public void delete(int id) { //deleta aluno
        aluno.remove(id);
        System.out.println("---------------------------------");
        System.out.println("Aluno Removido");
        System.out.println("---------------------------------");

    }
    
    public String buscaNome(int codigo) {
        for (int i = 0; i < index().size(); i++) {
            if (index().get(i).getMatricula() == codigo) {
                return index().get(i).getNome();
            }
        }
        return "Nao encontrado";
    }
}
