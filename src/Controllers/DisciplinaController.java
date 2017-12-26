/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Disciplina;
import java.util.ArrayList;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public class DisciplinaController implements Controller {

    ArrayList<Disciplina> disc = new ArrayList();

    public ArrayList<Disciplina> index() {
        return this.disc;
    }

    @Override
    public void store(String[] dados) {
        Disciplina model = new Disciplina(Integer.valueOf(dados[0]), dados[1].toUpperCase());
        disc.add(model);
        System.out.println("---------------------------------");
        System.out.println("Disciplina Salva Com Sucesso");
    }

    @Override
    public void show() {
        for (int i = 0; i < disc.size(); i++) {
            System.out.println(disc.get(i).getCodigodisc() + ": " + disc.get(i).getNome());
        }
    }

    @Override
    public void update(String[] dados, int id) {
        disc.get(id).setCodigodisc(Integer.valueOf(dados[0]));
        disc.get(id).setNome(dados[1].toUpperCase());
    }

    @Override
    public void delete(int id) {
        disc.remove(id);
        System.out.println("---------------------------------");
        System.out.println("Disciplina Removida.");
        System.out.println("---------------------------------");
    }

    public String buscaNome(int codigo) {
        for (int i = 0; i < index().size(); i++) {
            if (index().get(i).getCodigodisc() == codigo) {
                return index().get(i).getNome();
            }
        }
        return "Nao encontrado";
    }

//Requisito do aluno poder se matricular em outra disciplina que já cursou apenas se sua media for menor que 5
    public boolean VerifDisc(HistoricoAlunoController hist, int matdisciplina, int mataluno) {
        String nomeDisc = buscaNome(matdisciplina);
        for (int i = 0; i < hist.index().size(); i++) {
            if (mataluno == hist.index().get(i).getMataluno() && nomeDisc.equals(hist.index().get(i).getDisciplina())) {
                if (hist.index().get(i).getMedia() < 5.0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
