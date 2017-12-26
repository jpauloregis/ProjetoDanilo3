/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Turma;
import java.util.ArrayList;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class TurmaController {

    ArrayList<Turma> turm = new ArrayList();

    public ArrayList<Turma> index() {
        return this.turm;
    }
    
    
    public boolean VerifTurmasProf (int codprof, int qtdMaxTurmas){
        int cont = 0;
        for(int i = 0; i < index().size(); i++){
            if(codprof == index().get(i).getCodprof()){
                cont++;
                if(cont == qtdMaxTurmas){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean VerifTurmasDisc (int codigodisc, int qtdMaxTurmas){
        int cont = 0;
        for(int i = 0; i < index().size(); i++){
            if(codigodisc == index().get(i).getMatdisciplina()){
                cont++;
                if(cont == qtdMaxTurmas){
                    return false;
                }
            }
        }
        return true;
    }

    public void store(String[] dados) { //salva a turma
        Turma model = new Turma(Integer.valueOf(dados[0]), Integer.valueOf(dados[1]), Integer.valueOf(dados[2]));
        turm.add(model);
        System.out.println("---------------------------------");
        System.out.println("Turma Salva Com Sucesso");

    }

    public void show(ProfessorController prof, DisciplinaController disc) {//mostra a turma
        for (int i = 0; i < turm.size(); i++) {
            System.out.println("---------------------------------");
            System.out.println(turm.get(i).getCodturma() + ": Professor(a): " + prof.buscaNome(turm.get(i).getCodprof()) + " - Disciplina: " + disc.buscaNome(turm.get(i).getMatdisciplina()));
        }
    }

    public void update(String[] dados, int id) {//atualiza os dados de turma
        turm.get(id).setCodturma(Integer.valueOf(dados[0]));
        turm.get(id).setMatdisciplina(Integer.valueOf(dados[1]));
        turm.get(id).setCodprof(Integer.valueOf(dados[2]));
    }

    public void delete(int id) {//remove uma turma
        turm.remove(id);
        System.out.println("Turma Removida.");
        System.out.println("---------------------------------");
    }

}
