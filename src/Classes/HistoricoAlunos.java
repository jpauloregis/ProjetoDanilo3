/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controllers.AlunoController;
import Controllers.DisciplinaController;
import Controllers.HistoricoAlunoController;
import Controllers.TurmaController;
import Models.HistoricoAluno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class HistoricoAlunos {

    ArrayList<HistoricoAluno> ArrayHistA;
    Scanner in = new Scanner(System.in);

    public void VerNotas(HistoricoAlunoController HistA, DisciplinaController disc, AlunoController aluno, TurmaController turm) {
        System.out.println("Digite matricula do Aluno:");
        String matAluno = in.nextLine();
        ArrayHistA = HistA.index();
        double globalMedia = 0.0;
        int denominador = 0;
        //System.out.println("Teste1: Tamanho: " + ArrayHistA.size());
        if (!ArrayHistA.isEmpty()) {
            System.out.println("---------------------------------");
            for (int i = 0; i < ArrayHistA.size(); i++) {
                //System.out.println("Teste2: " + matAluno + " == " + ArrayHistA.get(i).getMataluno());
                if (matAluno.equals(String.valueOf(ArrayHistA.get(i).getMataluno()))) {
                    System.out.println("Aluno: " + aluno.buscaNome(Integer.valueOf(matAluno)));
                    System.out.println("Disciplina: " + ArrayHistA.get(i).getDisciplina());
                    System.out.println("Media: " + ArrayHistA.get(i).getMedia());
                    globalMedia += ArrayHistA.get(i).getMedia();
                    denominador++;
                }
            }
            if(denominador == 0){
                denominador++;
            }
            System.out.println("-----------------------------");
            System.out.println("CRE: "+globalMedia/denominador);
        } else {
            System.out.println("Nao existe historico de alunos.");
        }
    }
}
