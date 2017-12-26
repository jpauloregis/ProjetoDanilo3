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
import Controllers.TurmaController;
import Models.AlunoTurma;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class AlunoTurmas {

    public static int id = 0;
    ArrayList<AlunoTurma> ArrayAturm;
    Scanner in = new Scanner(System.in);
    String nomeDisc = "";
    int posicao = 0;
    int alunoCont = 0;

    public void colocar(AlunoTurmaController Aturm, TurmaController turmaController,
            AlunoController alunoController, HistoricoAlunoController HistController, DisciplinaController discController) {
        int contador = 0;
        String CodTurma, MatAluno;

        while (true) {
            //verificamos se a turma e o aluno digitados sÃ£o os mesmos do nosso array turma e aluno
            //se sim, o aluno pode ser incluido na turma.
            System.out.println("---------------------------------");
            System.out.println("Informe o Codigo da Turma que deseja inserir alunos");
            System.out.println("---------------------------------");
            CodTurma = in.nextLine();

            if (!turmaController.index().isEmpty()) {

                for (int i = 0; i < turmaController.index().size(); i++) {
                    if (turmaController.index().get(i).getCodturma() == Integer.valueOf(CodTurma)) {
                        posicao = i;
                        contador++;
                        break;
                    }
                }

                if (contador > 0) {
                    discController.buscaNome(turmaController.index().get(posicao).getMatdisciplina());
                    break;
                }
                System.out.println("Turma nao encontrada");

            }
        }

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("Informe a matricula do Aluno: ");
            MatAluno = in.nextLine();

            /*if (MatAluno.equals("0")) {
            break;
            }*/
            if (!alunoController.index().isEmpty()) {

                contador = 0;
                for (int i = 0; i < alunoController.index().size(); i++) {
                    if (alunoController.index().get(i).getMatricula() == Integer.valueOf(MatAluno)) {
                        contador++;
                        alunoCont++;
                        //System.out.println("Aluno Contador: " + alunoCont);
                        //System.out.println("contador: " + contador);
                        break;
                    }
                }
                if (contador > 0) {
                    if (alunoCont > 3) { //Restrincao do aluno possuir no maximo 3 turmas
                        System.out.println("Aluno com numero maximo de turmas.");
                        break;
                    } else {
                        //Restrincao do aluno se matricular novamente apenas se sua media for <5
                        int matdisciplina = turmaController.index().get(posicao).getMatdisciplina();
                        if (discController.VerifDisc(HistController, matdisciplina, Integer.valueOf(MatAluno))) {
                            int idTurmaAluno = getProximoId();
                            Integer[] dados = {
                                idTurmaAluno,
                                Integer.valueOf(MatAluno),
                                Integer.valueOf(CodTurma)};
                            Aturm.store(dados);
                            String[] hist = {
                                String.valueOf(idTurmaAluno),
                                nomeDisc = discController.buscaNome(turmaController.index().get(posicao).getMatdisciplina()),
                                String.valueOf(MatAluno),
                                String.valueOf(CodTurma),
                                "0", "0", "0"};
                            HistController.store(hist);
                            System.out.println("Aluno Salvo na Turma");
                            break;
                        }else{
                            System.out.println("Media do aluno precisa ser < 5 para se matricular novamente.");
                        }
                    }
                } else {
                    System.out.println("Aluno nao encontrado");
                    break;
                }

            }
        }
    }

    public int getProximoId() {
        return this.id++;
    }

    public boolean VerifTurmasAluno(int codaluno, int qtdMaxTurmas) {
        int cont = 0;
        for (int i = 0; i < ArrayAturm.size(); i++) {
            if (codaluno == ArrayAturm.get(i).getMatAluno()) {
                cont++;
                if (cont == qtdMaxTurmas) {
                    return false;
                }
            }
        }
        return true;
    }
}
