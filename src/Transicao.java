
public class Transicao {
    private String valor;
    private Estado estadoDest;
    private Estado estadoInvalido;

    public Transicao() {}

    public Transicao(String valor, Estado estadoDest) {
        this.valor = valor;
        this.estadoDest = estadoDest;
    }

    public Transicao(String valor, Estado estadoDest, Estado estadoInvalido) {
        this.valor = valor;
        this.estadoDest = estadoDest;
        this.estadoInvalido = estadoInvalido;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Estado getEstadoDest() {
        return estadoDest;
    }

    public void setEstadoDest(Estado estadoDest) {
        this.estadoDest = estadoDest;
    }
}
