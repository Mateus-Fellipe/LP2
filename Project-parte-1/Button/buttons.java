package Button;

import Figures.Figure;
import java.awt.*;
import ivisible.IVisible;

public class buttons implements IVisible{
    private int posX, posY, index, tam = 45;
    private Figure fig;

    public buttons(int index, Figure fig){
        this.index = index;
        this.posX = 5; // Posição vertical dos botões.
        this.posY = index*45 + 30; // Posiçao vertical dos botões. Começando a partir de 30px.
    
        this.fig = fig;
        this.fig.setterX(10); // Posição horizontal das figuras dentro dos botões. Com 5px de margem
        this.fig.setterY(index*45 + 35); // Posição vertical das figuras dentro dos botões. Começando a partir de 35px e com 5 px de margem.
        this.fig.setterW(35); // Largura da figura.
        this.fig.setterH(35); // Altura da figura.
    }

    public void paint(Graphics g, boolean selected){
        Graphics2D g2d = (Graphics2D) g;

        if (selected){ // Verifica se foi clicado.
            g2d.setColor(Color.GRAY);
        } else {
            g2d.setColor(Color.LIGHT_GRAY);
        }
        g2d.fillRect(posX, posY, tam, tam);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(posX, posY, tam, tam);

        this.fig.paint(g, false); // Desenha a figura no botão.
    }

    public boolean clicked(int pX, int pY){ // Verifica se o botão foi clicado
        if (pX >= this.posX && pX <= this.posX + tam && pY >= this.posY && pY <= this.posY + tam){
            return true;
        }

        return false;
    }
}
