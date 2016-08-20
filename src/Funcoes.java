import java.util.Arrays;
import java.util.List;

public class Funcoes {
    private List<String> resultString;
    private List<Character> resultChar;

    public List<String> separarString (String s) {
        String[] itens = s.split(",");
        resultString = Arrays.asList(itens);
        return resultString;
    }

    public List<Character> separarChar (List<String> a) {
        for(int i = 0; i < a.size(); i++) {
            char[] itens = a.get(i).toCharArray();
            for(int j = 0; j < itens.length; j++) {
                resultChar.add(itens[j]);
            }
        }
        return resultChar;
    }

    public void imprimirString(List<String> teste) {
        for(int i=0; i<teste.size(); i++) {
            System.out.println(teste.get(i));
        }
    }

    public void imprimirChar(List<Character> teste) {
        for(int i=0; i<teste.size(); i++) {
            System.out.println(teste.get(i));
        }
    }
}
