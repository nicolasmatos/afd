import java.util.List;

public class Principal {

    public static void main(String[] args) {

        Funcoes teste = new Funcoes();
        List<String> var = teste.separarString("101,102,203");
        List<Character> var2 = teste.separarChar(var);
    }
}