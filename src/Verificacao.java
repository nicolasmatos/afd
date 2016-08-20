import java.util.List;

public class Verificacao extends Funcoes{
    private int i, j, saida = 0;
    private char estadoProx;
    private char estadoIni;
    private String stringEstadosFinais;
    private String stringAlfabeto;
    private String stringTransicoes;
    private String stringEntrada;

    private List<String> estadosFinais = this.separarString(stringEstadosFinais);
    private List<String> alfabeto = this.separarString(stringAlfabeto);
    private List<String> transicoesListS = this.separarString(stringTransicoes);
    private List<Character> transicoes = this.separarChar(transicoesListS);
    private List<String> entrada = this.separarString(stringEntrada);

    private int validaEntrada() {
        for(i = 0; i < entrada.size(); i++) {
            for(j = 0; j < transicoes.size(); j+=3) {
                if(estadoIni == transicoes.get(j)
                   && entrada.get(i).equals(transicoes.get(j + 1))){
                    estadoProx = transicoes.get(j + 2);
                    estadoIni = estadoProx;
                }
            }
        }

        if(estadosFinais.contains(estadoIni)) {
            saida = 1;
        }

        return saida;
    }
}
