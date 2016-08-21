import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transformacoes {
    private List<String> resultString;
    private ArrayList<Character> resultChar = new ArrayList<Character>();
    private ArrayList<Character> resultChar2 = new ArrayList<Character>();

    public List<String> separarString (String s) {
        String[] itens = s.split(",");
        resultString = Arrays.asList(itens);
        return resultString;
    }

    public ArrayList<Character> separarChar (List<String> a) {
        for(int i = 0; i < a.size(); i++) {
            String itens = a.get(i);
            for(char c : itens.toCharArray()) {
                resultChar.add(c);
            }
        }
        return resultChar;
    }

    public ArrayList<Character> separarChar (String a) {
            for(char c : a.toCharArray()) {
                resultChar2.add(c);
            }
        return resultChar2;
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
