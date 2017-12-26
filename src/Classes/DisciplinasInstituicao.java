/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controllers.DisciplinaController;
import Controllers.TurmaController;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class DisciplinasInstituicao {

    Disciplinas disc = new Disciplinas();
    DisciplinaController discController;
    Turmas turm = new Turmas();
    TurmaController turmController;

    public DisciplinasInstituicao(DisciplinaController discController, TurmaController turmController) {
        this.discController = discController;
        this.turmController = turmController;
    }

    public void menu() {
        Scanner in = new Scanner(System.in);
        int opcao = 0;
        do {
                disc.ver(discController);

                System.out.println("---------------------------------");
                System.out.println("1 - Criar nova disciplina.");
                System.out.println("2 - Remover disciplina existente.");
                System.out.println("3 - Voltar");
                System.out.println("---------------------------------");
                switch (opcao = in.nextInt()) {
                    case 1:
                        disc.criar(discController);
                        break;
                    case 2:
                        disc.remover(discController,turmController);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("---------------------------------");
                        System.out.println("Opcao Invalida!");
                        System.out.println("---------------------------------");
                        break;
                }
        } while (opcao != 3);
    }
}
