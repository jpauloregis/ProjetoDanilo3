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
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class Menu {

    AlunoController aluno = new AlunoController();
    ProfessorController prof = new ProfessorController();
    DisciplinaController disc = new DisciplinaController();
    TurmaController turm = new TurmaController();
    AlunoTurmaController Aturm = new AlunoTurmaController();
    HistoricoAlunoController histc = new HistoricoAlunoController();
    
    public static void main(String[] args) {
        //nosso main
        Menu MenuInicial = new Menu();
        MenuInicial.menu();
    }

    public void menu() {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        do {
                System.out.println("---------------------------------");
                System.out.println("Menu Inicial:");
                System.out.println("1 - Ver membros da instituição ");
                System.out.println("2 - Ver disciplinas ofertadas ");
                System.out.println("3 - Ver turmas ");
                System.out.println("4 - Sair do programa");
                System.out.println("---------------------------------");
                switch (opcao = in.nextInt()) {
                    case 1:
                        MembrosInstituicao membros = new MembrosInstituicao(aluno, turm, prof, histc, disc);
                        membros.menu();
                        break;
                    case 2:
                        DisciplinasInstituicao disciplinas = new DisciplinasInstituicao(disc, turm);
                        disciplinas.menu();
                        break;
                    case 3:
                        TurmasInstituicao turmas = new TurmasInstituicao(turm, disc, prof, aluno, Aturm, histc);
                        turmas.menu();
                        break;
                    case 4:
                        System.out.println("Tchau!");
                        break;
                    default:
                        System.out.println("---------------------------------");
                        System.out.println("Opcao Invalida!");
                        System.out.println("---------------------------------");
                        break;
                }
        } while (opcao != 4);
    }
}
