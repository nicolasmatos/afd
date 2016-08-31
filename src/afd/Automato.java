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
    //private ArrayList<String> entrada;
   
    private String[] entrada;// = txtEntrada.split("/");
    private Estado[] estados;// = new Estado[qtdEstados + 1];  

    public Automato(String txtAlfabeto, int qtdEstados, String txtTransicoes, String txtInicial, String txtFinais, String txtEntrada) {
        this.txtAlfabeto = txtAlfabeto;
        this.qtdEstados = qtdEstados;
        this.txtTransicoes = txtTransicoes;
        this.txtInicial = txtInicial;
        this.txtFinais = txtFinais;    
        this.txtEntrada = txtEntrada;
        entrada = txtEntrada.split("/");
        estados = new Estado[qtdEstados + 1];
        
        eIvalido = false;
        saida = 0;
        //entrada = new ArrayList<>();
    }
    
    public Automato(){}

    public int getQtdEstados() {
        return qtdEstados;
    }

    public Estado[] getEstados() {
        return estados;
    }
    
    public boolean verificarEntrada(){
        boolean result = false;
        String[] alfabeto = txtAlfabeto.split(",");
        String[] entrada = txtEntrada.split("/");
        
        for(int i = 0; i < entrada.length; i++) {
            result = false;
            for(int j = 0; j < alfabeto.length; j++) {
                if(entrada[i].equals(alfabeto[j])){
                    result = true;
                    j = alfabeto.length;
                } 
                else if (j + 1 == alfabeto.length && result != true) {
                    i = entrada.length;
                }
            }
        }
        return result;
    }

    public String verificacao() {
        String resultado = "";
        
        if(!this.verificarEntrada()) {
            return resultado+="Entrada inválida!";
        }
        
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

        for(int i = 0; i < entrada.length; i++) {
            for(int j = 0; j < estadoAtual.getTransicoes().size(); j++) {
                resultado+="\nEstado atual: " + estadoAtual.getRepresentacao();
                resultado+="\nValor: " + estadoAtual.getTransicoes().get(j).getValor();
                resultado+="\nEntrada: " + entrada[i];
                if (estadoAtual.getTransicoes().get(j).getValor().equals(entrada[i])) {
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

        resultado+="\n" + (eIvalido ? "Estado invalido" : "Estado Final: " + estadoAtual.getRepresentacao());
        resultado+="\nSaida: " + saida;
        return resultado;
    }
}