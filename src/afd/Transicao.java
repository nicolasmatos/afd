
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd;

public class Transicao {
    private String valor;
    private Estado estadoDest;

    public Transicao() {}

    public Transicao(String valor, Estado estadoDest) {
        this.valor = valor;
        this.estadoDest = estadoDest;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Estado getEstadoDest() {
        return estadoDest;
    }

    public void setEstadoDest(Estado estadoDest) {
        this.estadoDest = estadoDest;
    }
}
