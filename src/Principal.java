import java.util.List;

public class Principal {

    public static void main(String[] args) {

        /*Funcoes teste = new Funcoes();
        List<String> var = teste.separarString("101,102,203");
        List<Character> var2 = teste.separarChar(var);
        teste.imprimirChar(var2);*/

        Verificacao v = new Verificacao();
        System.out.println(v.validaEntrada());
    }
}