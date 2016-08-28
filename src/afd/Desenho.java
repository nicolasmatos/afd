package afd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Desenho extends JPanel{
    int qtdEstados;
    int centro = 165;
    int raio = 145;

    public void setQtdEstados(int qtdEstados) {
        this.qtdEstados = qtdEstados;
    }
    
     /**
     * Desenha os estados na tela
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < qtdEstados; i++) {

            double cosseno = Math.cos(Math.toRadians(360 * i / qtdEstados));
            double seno = Math.sin(Math.toRadians(360 * i / qtdEstados));

            int x = centro + (int) (raio * cosseno);
            int y = centro + (int) (raio * seno);

            DesenharEstados(g, i, x, y);
        }
    }
    
    /**
     * Desenha um vertice na tela
     * @param g
     * @param representacao
     * @param x
     * @param y 
     */
    private void DesenharEstados(Graphics g, int representacao, int x, int y) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(representacao + "", x + ((representacao < 10) ? 6 : 3), y + 15);
    }
}
