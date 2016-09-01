package afd;

public class Automato {
    
    private Estado estadoAtual;
    
    private boolean eIvalido;
    
    private int qtdEstados;
    private int saida;
    
    private String txtAlfabeto;
    private String txtTransicoes;
    private String txtInicial;
    private String txtFinais;
    private String txtEntrada;
   
    private String[] entrada;
    private Estado[] estados;
    
    public Automato(){}
    
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
    }
    
    /**
     * Verifica se a entrada recebida é válida 
     */
    public boolean verificarEntrada(){
        boolean result = false;
        String[] alfabeto = txtAlfabeto.split(",");
        
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
    
    /**
     * Inicializa o array de estados 
     * Inicializa o array de transições determinando as transições de cada estado
     * Determina o estado inicial e o conjunto de estados finais
     */
    public void setValores () {
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
    }

    /**
     * Verifica se a entrada leva a um estado final válido
     */
    public String verificacao() {
        this.setValores();
        String resultado = "";
        
        if(!this.verificarEntrada()) {
            return resultado+="Entrada inválida!";
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
                    i = entrada.length;
                }
                resultado+="\nEstado Destino: " + estadoAtual.getRepresentacao() + "\n";
            }
        }

        if (estadoAtual.iseFinal() && eIvalido != true) {
            saida = 1;
        }

        resultado+="\n" + (eIvalido ? "Estado invalido" : "Estado Final: " + estadoAtual.getRepresentacao());
        resultado+="\nSaida: " + saida;
        return resultado;
    }
    
    public int getQtdEstados() {return qtdEstados;}
    public Estado[] getEstados() {return estados;}
    
}