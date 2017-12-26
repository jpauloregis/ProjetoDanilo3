/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controllers.ProfessorController;
import Models.Professor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class Professores {

    ArrayList<Professor> ArrayProf;

    Scanner in = new Scanner(System.in);

    public void vincular(ProfessorController prof) {
        try {
            int cont = 0;
            ArrayProf = prof.index();
            System.out.println("---------------------------------");
            System.out.println("Informe o nome do Professor");
            System.out.println("---------------------------------");
            String Nome = in.nextLine();
            System.out.println("---------------------------------");
            System.out.println("Informe a matricula do Professor");
            System.out.println("---------------------------------");
            String Matricula = in.nextLine();

            if (!ArrayProf.isEmpty()) {
                for (int i = 0; i < ArrayProf.size(); i++) {
                    if (Matricula.equals(String.valueOf(ArrayProf.get(i).getMatricula()))) {
                        cont++;
                        break;
                    }
                }
                if (cont > 0) { //restrincao para nao existires professores com matriculas iguais
                    System.out.println("Matricula ja existe, por favor insira uma nova.");
                } else {
                    String[] dados = {Matricula, Nome};
                    prof.store(dados);
                }
            } else {
                String[] dados = {Matricula, Nome};
                prof.store(dados);
            }
        } catch (Exception e) {
            System.out.println("Entrada Invalida");
        }
    }

    public void desvincular(ProfessorController prof) {
        ArrayProf = prof.index();
        if (!ArrayProf.isEmpty()) {
                System.out.println("---------------------------------");
                System.out.println("Informe a matricula do Professor para a remoção");
                System.out.println("---------------------------------");
                String Matricula = in.nextLine();
                for (int i = 0; i < ArrayProf.size(); i++) {
                    if (Matricula.equals(String.valueOf(ArrayProf.get(i).getMatricula()))) {
                        prof.delete(i);
                        break;
                    }
                }
        } else {
            System.out.println("---------------------------------");
            System.out.println("Não existem professores matriculados.");
        }
    }

    public void ver(ProfessorController prof) {
        ArrayProf = prof.index();
        if (!ArrayProf.isEmpty()) {
            prof.show();
        } else {
            System.out.println("---------------------------------");
            System.out.println("Não existem professores matriculados.");
        }
    }
}
