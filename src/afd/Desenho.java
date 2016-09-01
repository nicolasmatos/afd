package afd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Desenho extends JPanel{
    int qtdEstados;
    int centro = 125;
    int raio = 100;
    Estado[] estados;

    public void setQtdEstados(int qtdEstados) {
        this.qtdEstados = qtdEstados;
    }
    
    public void setEstados(Estado[] estados) {
        this.estados = estados;
    }
    
     /**
     * Desenha os estados na tela
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {        
        g.setColor(Color.white);
        g.fillRect(0, 0, 500, 500);
        DesenharLinha(g);
        for (int i = 1; i < qtdEstados+1; i++) {

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
        if(estados[representacao].iseFinal()) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.GREEN);
        }
        g.fillOval(x, y, 20, 20);
        
        if(estados[representacao].iseInicial()) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.DARK_GRAY);
        }
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(representacao + "", x + ((representacao < 10) ? 6 : 3), y + 15);
    }
    
    /**
     * Passa os parametros para desenhar as arestas
     * @param g
     */
    private void DesenharLinha(Graphics g) {
        if(estados != null){
            for (int i = 1; i < estados.length; i++) {
                Estado e = estados[i];
                for (int j = 0; j < e.getTransicoes().size(); j++) {
                    Transicao t = e.getTransicoes().get(j);
                    if(e.equals(t.getEstadoDest())) {
                        Arco(g, Integer.parseInt(e.getRepresentacao()));
                    }
                    else {
                        Linha(g, Integer.parseInt(e.getRepresentacao()), Integer.parseInt(t.getEstadoDest().getRepresentacao()));
                    }
                    DesenharTransicoes(g, Integer.parseInt(e.getRepresentacao()), Integer.parseInt(t.getEstadoDest().getRepresentacao()));
                }
            }
        }
    }
    
    /**
     * Passa os parametros para desenhar as arestas
     * @param g
     */
    private void DesenharTransicoes(Graphics g, int inicio, int destino) {
        String valor = "";
        for (int i = 0; i < estados[inicio].getTransicoes().size(); i++) {
            Transicao t = estados[inicio].getTransicoes().get(i);
            if (Integer.parseInt(t.getEstadoDest().getRepresentacao()) == destino) {
                valor = valor + t.getValor() + ", ";
            }
        }
        valor = valor.substring (0, valor.length() - 2);
        
        int xInicio, yInicio, xDestino, yDestino;

        double cossenoInicio = Math.cos(Math.toRadians(360 * inicio / qtdEstados));
        double senoInicio = Math.sin(Math.toRadians(360 * inicio / qtdEstados));
        
        double cossenoDestino = Math.cos(Math.toRadians(360 * destino / qtdEstados));
        double senoDestino = Math.sin(Math.toRadians(360 * destino / qtdEstados));

        xInicio = centro + (int) (raio * cossenoInicio);
        yInicio = centro + (int) (raio * senoInicio);

        xDestino = centro + (int) (raio * cossenoDestino);
        yDestino = centro + (int) (raio * senoDestino);
        
        g.setColor(Color.CYAN);
        g.fillRect(xInicio - 2 + (int) ((xDestino - xInicio) * 0.25), yInicio - 12 + (int) ((yDestino - yInicio) * 0.25), 52, 17);

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(inicio + "->" + destino + ": " + valor, xInicio + (int) ((xDestino - xInicio) * 0.25), yInicio + (int) ((yDestino - yInicio) * 0.25));
    }
    
    /**
     * Desenha uma arestas na tela
     * @param g
     * @param inicio
     * @param destino 
     */
    private void Linha(Graphics g, int inicio, int destino) {
        //System.out.println("Linha\n Inicio: " + inicio + "\nFim: " + destino + "\n\n\n");
        int xInicio, yInicio, xDestino, yDestino;

        double cossenoInicio = Math.cos(Math.toRadians(360 * inicio / qtdEstados));
        double senoInicio = Math.sin(Math.toRadians(360 * inicio / qtdEstados));
        
        double cossenoDestino = Math.cos(Math.toRadians(360 * destino / qtdEstados));
        double senoDestino = Math.sin(Math.toRadians(360 * destino / qtdEstados));

        xInicio = centro + (int) (raio * cossenoInicio);
        yInicio = centro + (int) (raio * senoInicio);

        xDestino = centro + (int) (raio * cossenoDestino);
        yDestino = centro + (int) (raio * senoDestino);

        g.setColor(Color.DARK_GRAY);
        //g.drawArc(xInicio, yInicio, xDestino, yDestino, 180, -180);
        //g.drawArc(xInicio + 10, yInicio + 10, xDestino + 10, yDestino + 10, 0, 0);
        g.drawLine(xInicio + 10, yInicio + 10, xDestino + 10, yDestino + 10);
    }
    
    /**
     * Desenha um arco de loop de um estado
     * @param g
     */
    private void Arco(Graphics g, int estado) {
        double cosseno = Math.cos(Math.toRadians(360 * estado / qtdEstados));
        double seno = Math.sin(Math.toRadians(360 * estado / qtdEstados));

        int x = centro + (int) (raio * cosseno);
        int y = centro + (int) (raio * seno);
        
        g.setColor(Color.DARK_GRAY);
        g.drawArc(x - 10, y - 30, 40, 40, 240, -300);        
    }
}
