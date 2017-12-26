/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controllers.AlunoController;
import Models.Aluno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class Alunos {

    ArrayList<Aluno> ArrayAluno;

    Scanner in = new Scanner(System.in);

    public void vincular(AlunoController aluno) {
        try {
            int cont = 0;
            ArrayAluno = aluno.index();
            System.out.println("---------------------------------");
            System.out.println("Informe o nome do Aluno");
            System.out.println("---------------------------------");
            String Nome = in.nextLine();
            System.out.println("---------------------------------");
            System.out.println("Informe a matricula do Aluno");
            System.out.println("---------------------------------");
            String Matricula = in.nextLine();

            if (ArrayAluno.isEmpty()) {
                String[] dados = {Matricula, Nome};
                aluno.store(dados);
            } else {
                for (int i = 0; i < ArrayAluno.size(); i++) {
                    if (Matricula.equals(String.valueOf(ArrayAluno.get(i).getMatricula()))) {
                        cont++;
                        break;
                    }
                }
                if (cont > 0) { //Restricao para o aluno nao possuir 2 matriculas iguais
                    System.out.println("Matricula ja existe, por favor insira uma nova.");
                } else {
                    String[] dados = {Matricula, Nome};
                    aluno.store(dados);
                }
            }
        } catch (Exception e) {
            System.out.println("Entrada Invalida");
        }
    }

    public void desvincular(AlunoController aluno) {
        ArrayAluno = aluno.index();
        if (!ArrayAluno.isEmpty()) {
            System.out.println("---------------------------------");
            System.out.println("Informe a matricula do Aluno para a remocao");
            System.out.println("---------------------------------");
            String Matricula = in.nextLine();

            for (int i = 0; i < ArrayAluno.size(); i++) {
                if (Matricula.equals(String.valueOf(ArrayAluno.get(i).getMatricula()))) {
                    aluno.delete(i);
                    break;
                }
            }
        } else {
            System.out.println("---------------------------------");
            System.out.println("Nao existem Alunos matriculados.");
        }
    }

    public void ver(AlunoController aluno) {
        ArrayAluno = aluno.index();
        if (!ArrayAluno.isEmpty()) {
            aluno.show();
        } else {
            System.out.println("---------------------------------");
            System.out.println("Nao existem Alunos matriculados.");
        }
    }
}
