import java.util.List;

public class Parametros extends Funcoes{
    private char estadoIni;
    private String stringEstadosFinais;
    private String stringAlfabeto;
    private String stringTransicoes;
    private String stringEntrada;

    private List<String> estadosFinais = this.separarString(stringEstadosFinais);
    private List<String> alfabeto = this.separarString(stringEstadosFinais);
    private List<String> transicoesListS = this.separarString(stringTransicoes);
    private List<Character> transicoes = this.separarChar(transicoesListS);
    private List<String> entrada = this.separarString(stringEntrada);

    public char getEstadoIni() {
        return estadoIni;
    }
    public List<String> getEstadosFinais() {
        return estadosFinais;
    }
    public List<String> getAlfabeto() {
        return alfabeto;
    }
    public List<Character> getTransicoes() {
        return transicoes;
    }
    public List<String> getEntrada() {
        return entrada;
    }
}
