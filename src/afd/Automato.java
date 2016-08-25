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
        entrada = new ArrayList<String>();
    }
    
    public Automato(){
        
    }

    public String verificacao() {
        String resultado = "";
        /*Estado estadoAtual;
        String txtAlfabeto = "+,-,0,1,2,3,4,5,6,7,8,9";
        int qtdEstados = 4, saida = 0;
        String txtTransicoes = "1/+/2,1/-/2,1/0/4,1/1/3,1/2/3,1/3/3,1/4/3,1/5/3,1/6/3,1/7/3,1/8/3,1/9/3,2/0/3,2/1/3,2/2/3,2/3/3,2/4/3,2/5/3,2/6/3,2/7/3,2/8/3,2/9/3,3/0/3,3/1/3,3/2/3,3/3/3,3/4/3,3/5/3,3/6/3,3/7/3,3/8/3,3/9/3";
        String txtInicial = "1";
        String txtFinais = "3,4";
        String txtEntrada = "+/0/-/3";
        ArrayList<String> entrada = new ArrayList<String>();*/

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