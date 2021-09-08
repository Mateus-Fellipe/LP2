package Figures;

import java.awt.*; // biblioteca gráfica
import javax.swing.*; // biblioteca de componentes

public class Rect{
  private int x, y, w, h;
  private int rC, gC, bC;
  private int rF, gF, bF;

  public Rect(int x, int y, int w, int h, int rC, int gC, int bC, int rF, int gF, int bF){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;

    this.rC = rC;
    this.gC = gC;
    this.bC = bC;
    this.rF = rF;
    this.gF = gF;
    this.bF = bF;
  }

  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(new Color(this.rC, this.gC, this.bC));
    g2d.drawRect(this.x, this.y, this.w, this.h);

    g2d.setColor(new Color(this.rF, this.gF, this.bF));
    g2d.fillRect(this.x, this.y, this.w, this.h);
  }
}
