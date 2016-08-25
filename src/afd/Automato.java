/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afd;

import java.util.ArrayList;

public class Automato {
    
    private Estado estadoAtual;
    private boolean eIvalido;
    private String txtAlfabeto;
    private int qtdEstados;
    private int saida;
    private String txtTransicoes;
    private String txtInicial;
    private String txtFinais;
    private String txtEntrada;
    private ArrayList<String> entrada;

    public Automato(String txtAlfabeto, int qtdEstados, String txtTransicoes, String txtInicial, String txtFinais, String txtEntrada) {
        this.txtAlfabeto = txtAlfabeto;
        this.qtdEstados = qtdEstados;
        this.txtTransicoes = txtTransicoes;
        this.txtInicial = txtInicial;
        this.txtFinais = txtFinais;    
        this.txtEntrada = txtEntrada;
        
        eIvalido = false;
        saida = 0;
        entrada = new ArrayList<>();
    }
    
    public Automato(){
        
    }

    public String verificacao() {
        String resultado = "";

        String[] alfabeto = txtAlfabeto.split(",");
        Estado[] estados = new Estado[qtdEstados + 1];

        for (int i = 1; i <= qtdEstados; i++) {
            estados[i] = new Estado();
            estados[i].setRepresentacao(Integer.toString(i));
        }

        for (String transicao : txtTransicoes.split(",")) {
            String[] elementosTransicao = transicao.split("/");

            Transicao t = new Transicao(elementosTransicao[1], estados[Integer.parseInt(elementosTransicao[2])]);
            estados[Integer.parseInt(elementosTransicao[0])].setTransicoes(t);
        }

        estados[Integer.parseInt(txtInicial)].seteInicial(true);
        estadoAtual = estados[Integer.parseInt(txtInicial)];

        for (String terminal : txtFinais.split(",")) {
            estados[Integer.parseInt(terminal)].seteFinal(true);
        }

        for (String e : txtEntrada.split("/")) {
            entrada.add(e);
        }

        for(int i = 0; i < entrada.size(); i++) {
            for(int j = 0; j < estadoAtual.getTransicoes().size(); j++) {
                resultado+="\nEstado atual: " + estadoAtual.getRepresentacao();
                resultado+="\nValor: " + estadoAtual.getTransicoes().get(j).getValor();
                resultado+="\nEntrada: " + entrada.get(i);
                if (estadoAtual.getTransicoes().get(j).getValor().equals(entrada.get(i))) {
                    estadoAtual = estadoAtual.getTransicoes().get(j).getEstadoDest();
                    j = estadoAtual.getTransicoes().size();
                }
                else if(j + 1 == estadoAtual.getTransicoes().size()) {
                    eIvalido = true;
                }
                resultado+="\nEstado Destino: " + estadoAtual.getRepresentacao() + "\n";
            }
        }

        if (estadoAtual.iseFinal() && eIvalido != true) {
            saida = 1;
        }
        else {
            saida = 0;
        }

        resultado+="\nEstado Final: " + estadoAtual.getRepresentacao();
        resultado+="\nSaida: " + saida;
        return resultado;
    }
}