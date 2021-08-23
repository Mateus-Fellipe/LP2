import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
    public static void main (String[] args) {
        Figure2DFrame Frame = new Figure2DFrame(); // Criando um novo frame
        Frame.setVisible(true);
     }
}

class Rect{ // Classe
     private int x, y;
     private int w, h;
     Rect (int x, int y, int w, int h) {
         this.x = x;
         this.y = y;
         this.w = w;
         this.h = h;
     }

     void print () { // Método
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this.w, this.h, this.x, this.y);
       }

    int area(){
      return this.w * this.h;
    }

    void drag(int dx, int dy){
      this.x = x + dx;
      this.y = y + dy;
    }

    public void paint (Graphics g){
      //super.paint(g);
      Graphics2D g2d = (Graphics2D) g;

      g2d.fillRect(this.x, this.y, this.w, this.h);

      g2d.setColor(Color.red);
      g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}


class Figure2DFrame extends JFrame {
    Rect r1, r2, r3;
    public Figure2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Retângulos");
        this.setSize(350, 350);
        this.r1 = new Rect(50, 50, 100, 75);
        this.r2 = new Rect(100, 100, 55, 75);
        this.r3 = new Rect(175, 125, 75, 120);
    }

    public void paint(Graphics g){
      super.paint(g);
      this.r1.paint(g);
      g.setColor(new Color(114, 225, 232));
      this.r2.paint(g);
      g.setColor(Color.pink);
      this.r3.paint(g);
    }


}
