/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Professor;
import java.util.ArrayList;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class ProfessorController implements Controller {

    ArrayList<Professor> professor = new ArrayList();
    public ArrayList<Professor> index() {
        return this.professor;
    }

    @Override
    public void store(String[] dados) {//salva o professor
        Professor model = new Professor(Integer.valueOf(dados[0]), dados[1].toUpperCase());
        professor.add(model);
        System.out.println("---------------------------------");
        System.out.println("Professor Cadastrado Com Sucesso");
    }

    @Override
    public void show() {//mostra o professor
        for (int i = 0; i < professor.size(); i++) {
            System.out.println(professor.get(i).getMatricula() + ": " + professor.get(i).getNome());
        }
    }

    @Override
    public void update(String[] dados, int id) {//atualiza os dados de professor
        professor.get(id).setMatricula(Integer.valueOf(dados[0]));
        professor.get(id).setNome(dados[1].toUpperCase());
    }

    @Override
    public void delete(int id) {//deleta o professor
        professor.remove(id);
        System.out.println("---------------------------------");
        System.out.println("Professor Removido");
        System.out.println("---------------------------------");

    }

    public String buscaNome(int codigo) { //busca o nome de professor para exibir nos metodos que chamamos
        for (int i = 0; i < index().size(); i++){
            if (index().get(i).getMatricula() == codigo) {
                return index().get(i).getNome();
            }
        }
        return "Não encontrado";
        }
}
