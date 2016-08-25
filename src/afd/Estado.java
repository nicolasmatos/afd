/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd;

import java.util.ArrayList;

public class Estado {
    private boolean eInicial;
    private boolean eFinal;
    private String representacao;
    private ArrayList<Transicao> transicoes = new ArrayList<>();

    public Estado() {}

    public Estado(boolean eInicial, boolean eFinal, String representacao, ArrayList<Transicao> transicoes) {
        this.eInicial = eInicial;
        this.eFinal = eFinal;
        this.representacao = representacao;
        this.transicoes = transicoes;
    }

    public boolean iseInicial() {
        return eInicial;
    }

    public void seteInicial(boolean eInicial) {
        this.eInicial = eInicial;
    }

    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Transicao t) {
        this.transicoes.add(t);
    }

    public String getRepresentacao() {
        return representacao;
    }

    public void setRepresentacao(String representacao) {
        this.representacao = representacao;
    }

    public boolean iseFinal() {
        return eFinal;
    }

    public void seteFinal(boolean eFinal) {
        this.eFinal = eFinal;
    }
}
