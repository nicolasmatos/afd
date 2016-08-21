import java.util.List;

public class Verificacao extends Transformacoes {
    private int i, j, saida = 0;
    private char estadoProx = '0';
    private char estadoIni = '1';
    private String stringEstadosFinais = "2,3";
    private String stringAlfabeto = "0,1";
    private String stringTransicoes = "101,112,203,212,302,312";
    private String stringEntrada = "00011";

    private List<String> estadosFinais = this.separarString(stringEstadosFinais);
    private List<String> alfabeto = this.separarString(stringAlfabeto);
    private List<String> transicoesListS = this.separarString(stringTransicoes);
    private List<Character> transicoes = this.separarChar(transicoesListS);
    private List<Character> entrada = this.separarChar(stringEntrada);


    public int validaEntrada() {
        for(i = 0; i < entrada.size(); i++) {
            System.out.println("\n\nEstadoIni: " + estadoIni);
            System.out.println("\n\nEntrada: " + entrada.get(i));
            for(j = 0; j < transicoes.size(); j+=3) {
                System.out.println("\n\nE: " + entrada.get(i) + " = T: " + transicoes.get(j + 1));
                if(estadoIni == transicoes.get(j)
                   && entrada.get(i) == transicoes.get(j + 1)){
                    estadoProx = transicoes.get(j + 2);
                    estadoIni = estadoProx;
                    j = transicoes.size();
                }
            }
            System.out.println("\n\nEstadoProx: " + estadoIni + "\n");
        }

        for(i = 0; i < estadosFinais.size(); i++) {
            for (j = 0; j < estadosFinais.get(i).length(); j++) {
                if(estadosFinais.get(i).charAt(j) == estadoIni) {
                    saida = 1;
                    j = estadosFinais.get(i).length();
                }
            }
            if (saida == 1) {
                i = estadosFinais.size();
            }
        }
        return saida;
    }
}
