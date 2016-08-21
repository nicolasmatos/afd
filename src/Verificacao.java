import java.util.List;

public class Verificacao extends Funcoes{
    private int i, j, saida = 0;
    private char estadoProx = '0';
    private char estadoIni = '1';
    private String stringEstadosFinais = "2,3";
    private String stringAlfabeto = "0,1";
    private String stringTransicoes = "101, 112, 203, 212, 302, 312";
    private String stringEntrada = "00011";

    private List<String> estadosFinais = this.separarString(stringEstadosFinais);
    private List<String> alfabeto = this.separarString(stringAlfabeto);
    private List<String> transicoesListS = this.separarString(stringTransicoes);
    private List<Character> transicoes = this.separarChar(transicoesListS);
    private List<Character> entrada = this.separarChar(stringEntrada);


    public int validaEntrada() {
        for(i = 0; i < entrada.size(); i++) {
            for(j = 0; j < transicoes.size(); j+=3) {
                if(estadoIni == transicoes.get(j)
                   && entrada.get(i) == transicoes.get(j + 1)){
                    estadoProx = transicoes.get(j + 2);
                    estadoIni = estadoProx;
                    j = transicoes.size();
                }
            }
        }

        if(estadosFinais.contains(estadoIni)) {
            saida = 1;
        }
        return saida;
    }
}
