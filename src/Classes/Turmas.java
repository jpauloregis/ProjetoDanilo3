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
import Models.Turma;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class Turmas {

    ArrayList<Turma> ArrayTurm;
    Scanner in = new Scanner(System.in);
    String codprof;

    void criar(TurmaController turm, DisciplinaController discip) {
        try {
            ArrayTurm = turm.index();
            System.out.println("---------------------------------");
            System.out.println("Informe um codigo para sua Turma");
            System.out.println("---------------------------------");
            String codturma = in.nextLine();
            System.out.println("---------------------------------");
            System.out.println("Informe o codigo/matricula da Disciplina da sua Turma");
            System.out.println("---------------------------------");
            String matdisciplina = in.nextLine();

            while (true) {
                System.out.println("---------------------------------");
                System.out.println("Informe o codigo do Professor da sua Turma");
                System.out.println("---------------------------------");
                codprof = in.nextLine();
                boolean confirm = turm.VerifTurmasProf(Integer.valueOf(codprof), 2);
                // Restrincao para o professor possuir no maximo 2 turmas
                if (confirm) {
                    break;
                }
                System.out.println("Professor com maximo de Turmas.");
            }
            String[] dados = {codturma, matdisciplina, codprof};
            turm.store(dados);

        } catch (Exception e) {
            System.out.println("Entrada Invalida");
        }
    }

    public void encerrar(TurmaController turm, HistoricoAlunoController hist, AlunoController aluno) {
        ArrayTurm = turm.index();
       if (!ArrayTurm.isEmpty()) {
            System.out.println("---------------------------------");
            System.out.println("Informe o codigo da turma a ser encerrada");
            System.out.println("---------------------------------");
            String Codigo = in.nextLine();
            
            for (int i = 0; i < ArrayTurm.size(); i++) {
                if (Codigo.equalsIgnoreCase(String.valueOf(ArrayTurm.get(i).getCodturma()))) {
                    //se a turma existir...
                    if(alunosNaTurma(hist, Codigo)){
                        //... e possuir alunos associados a ela...
                        porNotas(hist, aluno, Codigo);
                        //ai chamamos o por notas para atribuir as notas e logo em seguida deletar a turma
                        //encerrando sua atividade no periodo
                        turm.delete(i);
                    }else{
                        System.out.println("Turma sem alunos");
                    }
                    break;
                }
            }
        } else {
            System.out.println("Nao existem turmas associadas.");
        }
    }

    public void remover(TurmaController turm, HistoricoAlunoController hist) {
        ArrayTurm = turm.index();
        if (!ArrayTurm.isEmpty()) {
            System.out.println("---------------------------------");
            System.out.println("Informe o codigo da turma a ser removida.");
            System.out.println("---------------------------------");
            String Codigo = in.nextLine();
            for (int i = 0; i < ArrayTurm.size(); i++) {
                if (Codigo.equalsIgnoreCase(String.valueOf(ArrayTurm.get(i).getCodturma()))) {
                    //se possuir turma...
                    if (!alunosNaTurma(hist, Codigo)) {
                        //e nÃ£o possuir alunos associados a ela
                        //pode excluir a turma direto sem precisar passar as notas
                        turm.delete(i);
                        break;
                    } else {
                        System.out.println("Turmas com alunos, nao pode remover");
                    }
                }
            }
        } else {
            System.out.println("Nao existem turmas associadas.");
        }
    }

    public void ver(TurmaController turm, ProfessorController prof, DisciplinaController disc) {
        if (!turm.index().isEmpty()) {
            turm.show(prof, disc);
        } else {
            System.out.println("Nao existem turmas associadas.");
        }
    }

    public boolean alunosNaTurma(HistoricoAlunoController hist, String codTurma) {
        //verifica se possui alunos na turma
        for (int i = 0; i < hist.index().size(); i++) {
            if (Integer.valueOf(codTurma) == hist.index().get(i).getId_turma()) {
                return true;
            }
        }
        return false;
    }

     public void porNotas(HistoricoAlunoController hist, AlunoController aluno, String codTurma){
        Double media, nota1, nota2;
        //colocamos as notas dos alunos de determinada turma para poder assim ser encerrada
        /*System.out.println("-----------------------------");
        System.out.println("Historico do Aluno:");
        for (int i = 0; i < hist.index().size(); i++) {
        System.out.println("Nome: "+aluno.buscaNome(hist.index().get(i).getMataluno()));
        System.out.println("Nota 1: "+hist.index().get(i).getNota1());;
        System.out.println("Nota 2: "+hist.index().get(i).getNota2());;
        System.out.println("Media: "+hist.index().get(i).getMedia());;
        System.out.println("-----------------------------");
        }*/
        
        for (int i = 0; i < hist.index().size(); i++) {
            if(Integer.valueOf(codTurma) == hist.index().get(i).getId_turma()){
                System.out.println("Aluno: "+aluno.buscaNome(hist.index().get(i).getMataluno()));
                System.out.println("Nota 1: ");
                nota1 = in.nextDouble();
                System.out.println("Nota 2: ");
                nota2 = in.nextDouble();
                media = (nota1 + nota2) / 2;

                String[] dados = {
                    String.valueOf(hist.index().get(i).getIdturmAluno()),
                    hist.index().get(i).getDisciplina(),
                    String.valueOf(hist.index().get(i).getMataluno()),
                    String.valueOf(hist.index().get(i).getId_turma()),
                    String.valueOf(nota1),
                    String.valueOf(nota2),
                    String.valueOf(media)
                };
                hist.update(dados, i);
            }
        }
        
        /*System.out.println("-----------------------------");
        System.out.println("Historico Atualizado do Aluno:");
        for (int i = 0; i < hist.index().size(); i++) {
        System.out.println("Nome: "+aluno.buscaNome(hist.index().get(i).getMataluno()));
        System.out.println("Nota 1: "+hist.index().get(i).getNota1());;
        System.out.println("Nota 2: "+hist.index().get(i).getNota2());;
        System.out.println("Media: "+hist.index().get(i).getMedia());;
        System.out.println("Disciplina: "+hist.index().get(i).getDisciplina());
        System.out.println("-----------------------------");
        }*/
        
    }
     
  
     
}
