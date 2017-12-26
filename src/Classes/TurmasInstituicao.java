/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controllers.AlunoController;
import Controllers.AlunoTurmaController;
import Controllers.DisciplinaController;
import Controllers.HistoricoAlunoController;
import Controllers.ProfessorController;
import Controllers.TurmaController;
import Models.Aluno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class TurmasInstituicao {
    ArrayList<Aluno> ArrayAluno;
    AlunoTurmas Aturma = new AlunoTurmas();
    AlunoTurmaController AturmController;
    Alunos Aluno = new Alunos();
    AlunoController alunoController;
    Turmas turm = new Turmas();
    TurmaController turmController;
    Disciplinas disc = new Disciplinas();
    DisciplinaController discController;
    Professores prof = new Professores();
    ProfessorController profController;
    HistoricoAlunoController HistController;
    

    TurmasInstituicao(TurmaController turm, DisciplinaController disc, ProfessorController prof, 
            AlunoController aluno, AlunoTurmaController Aturm, HistoricoAlunoController histc) {
        this.turmController = turm;
        this.discController = disc;
        this.profController = prof;
        this.alunoController = aluno;
        this.AturmController = Aturm;
        this.HistController = histc;
    }

    public void menu() {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        do {
            turm.ver(turmController, profController, discController);

            System.out.println("---------------------------------");
            System.out.println("1 - Criar uma nova turma ");
            System.out.println("2 - Adicionar alunos em uma turma");
            System.out.println("3 - Encerrar turma em atividade");
            System.out.println("4 - Remover turma ");
            System.out.println("5 - Voltar");
            System.out.println("---------------------------------");
            switch (opcao = in.nextInt()) {
                case 1:
                    System.out.println("---------------------------------");
                    System.out.println("Professores Casdastrados:");
                    prof.ver(profController);
                    System.out.println("---------------------------------");
                    System.out.println("Disciplinas Disponiveis:");
                    disc.ver(discController);
                    turm.criar(turmController,discController);
                    break;
                case 2:                   
                    System.out.println("---------------------------------");
                    System.out.println("Alunos Casdastrados:");
                    Aluno.ver(alunoController);
                    Aturma.colocar(AturmController, turmController, alunoController, HistController, discController);
                    break;
                case 3:
                    turm.encerrar(turmController, HistController, alunoController);
                    break;
                case 4:
                    turm.remover(turmController, HistController);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Opcao Invalida!");
                    System.out.println("---------------------------------");
                    break;
            }
        } while (opcao != 5);
    }
}
