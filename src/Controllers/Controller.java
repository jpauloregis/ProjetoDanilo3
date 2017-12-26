/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author Joao Paulo e Matheus Gomes
 */
public interface Controller {
    public void store(String[] dados); //armazena os dados
    public void show(); //mostra os dados
    public void update(String[] dados, int id); //atualiza os dados
    public void delete(int id); //deleta os dados
}
