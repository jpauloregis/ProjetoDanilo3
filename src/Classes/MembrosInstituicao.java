/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controllers.AlunoController;
import Controllers.DisciplinaController;
import Controllers.HistoricoAlunoController;
import Controllers.ProfessorController;
import Controllers.TurmaController;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class MembrosInstituicao {

    Alunos aluno = new Alunos();
    Professores prof = new Professores();
    HistoricoAlunos hist = new HistoricoAlunos();
    AlunoController alunoController;
    ProfessorController profController;
    HistoricoAlunoController histController;
    DisciplinaController discController;
    TurmaController turmController;

    public MembrosInstituicao(AlunoController alunoController, TurmaController turmController, ProfessorController profController, HistoricoAlunoController histController, DisciplinaController discController) {
        this.alunoController = alunoController;
        this.profController = profController;
        this.histController = histController;
        this.discController = discController;
        this.turmController = turmController;
    }

    public void menu() {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("---------------------------------");
            System.out.println("1 - Vincular professor a instituição ");
            System.out.println("2 - Vincular aluno a instituição");
            System.out.println("3 - Desvincular professor da instituição");
            System.out.println("4 - Desvincular aluno a instituição");
            System.out.println("5 - Ver alunos matriculados");
            System.out.println("6 - Ver professores matriculados");
            System.out.println("7 - Ver notas de aluno");
            System.out.println("8 - Voltar");
            System.out.println("---------------------------------");
            switch (opcao = in.nextInt()) {
                case 1:
                    prof.vincular(profController);
                    break;
                case 2:
                    aluno.vincular(alunoController);
                    break;
                case 3:
                    prof.desvincular(profController);
                    break;
                case 4:
                    aluno.desvincular(alunoController);
                    break;
                case 5:
                    aluno.ver(alunoController);
                    break;
                case 6:
                    prof.ver(profController);
                    break;
                case 7:
                    hist.VerNotas(histController, discController, alunoController, turmController);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("---------------------------------");
                    System.out.println("Opcao Invalida!");
                    System.out.println("---------------------------------");
                    break;
            }
        } while (opcao != 8);
    }
}
