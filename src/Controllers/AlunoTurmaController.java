/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.AlunoTurma;
import java.util.ArrayList;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class AlunoTurmaController {

    private static int id = 0;
    ArrayList<AlunoTurma> Aturm = new ArrayList();

    public ArrayList<AlunoTurma> index() {
        return this.Aturm;
    }

    public int getProximoId() {
        return this.id++;
    }

    public void store(Integer[] dados) {
        AlunoTurma model = new AlunoTurma(Integer.valueOf(dados[0]), Integer.valueOf(dados[1]), Integer.valueOf(dados[2]));
        Aturm.add(model);
    }

    public void show() {
        for (int i = 0; i < Aturm.size(); i++) {
            System.out.println(Aturm.get(i).getIdTurma() + ": " + Aturm.get(i).getMatAluno());
        }
    }
    
    public boolean TurmaVazia(int idTurma){
        for (int i = 0; i < index().size(); i++) {
            if(idTurma == index().get(i).getIdTurma()){
                return false;
            }
        }
        return true;
    }
}
