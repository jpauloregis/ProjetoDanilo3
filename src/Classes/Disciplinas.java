/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controllers.DisciplinaController;
import Controllers.TurmaController;
import Models.Disciplina;
import Models.Turma;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author João Paulo e Matheus Gomes
 */
class Disciplinas {

    ArrayList<Disciplina> ArrayDisc;
    ArrayList<Turma> ArrayTurm;
    Scanner in = new Scanner(System.in);

    public void criar(DisciplinaController disc) {
        try {
            ArrayDisc = disc.index();
            int cont = 0;
            System.out.println("---------------------------------");
            System.out.println("Informe o nome da Disciplina.");
            System.out.println("---------------------------------");
            String nome = in.nextLine();
            System.out.println("---------------------------------");
            System.out.println("Informe o codigo da Disciplina");
            System.out.println("---------------------------------");
            String codigodisc = in.nextLine();
            if (!ArrayDisc.isEmpty()) {
                for (int i = 0; i < ArrayDisc.size(); i++) {
                    if (nome.toUpperCase().equals(ArrayDisc.get(i).getNome()) || codigodisc.equals(String.valueOf(ArrayDisc.get(i).getCodigodisc()))) {
                        cont++;
                        break;
                    }
                }
                if (cont > 0) { //Restricao para nao existir 2 disciplinas iguais
                    System.out.println("---------------------------------");
                    System.out.println("Disciplina já existe, adicione outra.");
                    System.out.println("---------------------------------");
                } else {
                    String[] dados = {codigodisc, nome};
                    disc.store(dados);
                }
            } else {
                String[] dados = {codigodisc, nome};
                disc.store(dados);
            }
        } catch (Exception e) {
            System.out.println("Entrada Invalida");
        }
    }

    public void remover(DisciplinaController disc, TurmaController turm) {
        ArrayDisc = disc.index();
        boolean status = true;
        int posicao = 0;

        if (!ArrayDisc.isEmpty()) {
            ver(disc);
            System.out.println("---------------------------------");
            System.out.println("Informe o codigo da disciplina a ser removida.");
            System.out.println("---------------------------------");
            String Matricula = in.nextLine();
            for (int i = 0; i < turm.index().size(); i++) {
                if (Integer.valueOf(Matricula) == turm.index().get(i).getMatdisciplina()) {
                    status = false;
                    posicao = i;
                    break;
                }
            }
            //Restrincao para nao remover disciplinas associadas a uma turma
            if (status) { 
                disc.delete(posicao);
            } else { 
                System.out.println("---------------------------------");
                System.out.println("Disciplina associada a Turma. Tente de novo.");
                System.out.println("---------------------------------");
            }

        } else {
            System.out.println("---------------------------------");
            System.out.println("Não existem disciplinas associadas.");
        }
    }

    public void ver(DisciplinaController disc) {
        ArrayDisc = disc.index();
        if (!ArrayDisc.isEmpty()) {
            disc.show();
        } else {
            System.out.println("---------------------------------");
            System.out.println("Não existem disciplinas associadas.");
        }
    }
}
