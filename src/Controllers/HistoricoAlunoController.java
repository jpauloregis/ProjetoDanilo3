/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.HistoricoAluno;
import java.util.ArrayList;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class HistoricoAlunoController {

    ArrayList<HistoricoAluno> HistA = new ArrayList();

    public ArrayList<HistoricoAluno> index() {
        return HistA;
    }

    public void store(String[] dados) { //guarda os dados do aluno em um historico
        HistoricoAluno model = new HistoricoAluno(Integer.valueOf(dados[0]), dados[1].toUpperCase(), Integer.valueOf(dados[2]),
                Integer.valueOf(dados[3]), Double.valueOf(0.0), Double.valueOf(0.0), Double.valueOf(0.0));
        HistA.add(model);
        System.out.println("---------------------------------");
    }

    public void show() { //exibe as notas dos alunos
        for (int i = 0; i < HistA.size(); i++) {
            System.out.println("Nota 1 do aluno: " + HistA.get(i).getMataluno() + " = " + HistA.get(i).getNota1());
            System.out.println("Nota 2 do aluno: " + HistA.get(i).getMataluno() + " = " + HistA.get(i).getNota2());
            System.out.println("Média do aluno: " + HistA.get(i).getMataluno() + " = " + HistA.get(i).getMedia());
        }
    }

    public void update(String[] dados, int id) {//atualiza os dados 
        HistA.get(id).setIdturmAluno(Integer.valueOf(dados[0]));
        HistA.get(id).setDisciplina(dados[1].toUpperCase());
        HistA.get(id).setMataluno(Integer.valueOf(dados[2]));
        HistA.get(id).setId_turma(Integer.valueOf(dados[3]));
        HistA.get(id).setNota1(Double.valueOf(dados[4]));
        HistA.get(id).setNota2(Double.valueOf(dados[5]));
        HistA.get(id).setMedia(Double.valueOf(dados[6]));
    }
    
}
