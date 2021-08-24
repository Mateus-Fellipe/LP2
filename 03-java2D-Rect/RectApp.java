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
     private int rP, gP, bP;
     private int rD, gD, bD;
     Rect (int x, int y, int w, int h,
     int rP, int gP, int bP, int rD, int gD, int bD) {
         this.x = x; //Propriedades
         this.y = y;
         this.w = w;
         this.h = h;
         this.rP = rP;
         this.gP = gP;
         this.bP = bP;
         this.rD = rD;
         this.gD = gD;
         this.bD = bD;
     }

     void print () { // Método
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this.w, this.h, this.x, this.y);
       }

    int area(){
      return this.w * this.h;
    } // Método

    void drag(int dx, int dy){
      this.x = x + dx;
      this.y = y + dy;
    } // Método

    public void paint (Graphics g){ // Método
      Graphics2D g2d = (Graphics2D) g;

      g2d.setColor(new Color(this.rP, this.gP, this.bP));
      g2d.fillRect(this.x, this.y, this.w, this.h);

      g2d.setColor(new Color(this.rD, this.gD, this.bD));
      g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}


class Figure2DFrame extends JFrame {
    Rect r1, r2, r3; // objetos
    public Figure2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Retângulos");
        this.setSize(350, 500);
        this.r1 = new Rect(125, 50, 100, 100,
        255, 0, 0,   //Preenchimento
        255, 153, 0 // Borda
        );

        this.r2 = new Rect(125, 200, 100, 100,
        255, 255, 0, // Preenchimento
        252, 227, 2 // Borda
        );

        this.r3 = new Rect(125, 350, 100, 100,
        0, 255, 0,  //Preenchimento
        0, 255, 85 // Borda
        );
    }

    public void paint(Graphics g){
      getContentPane().setBackground(Color.black);
      super.paint(g);
      this.r1.paint(g);
      this.r2.paint(g);
      this.r3.paint(g);
    }
}
