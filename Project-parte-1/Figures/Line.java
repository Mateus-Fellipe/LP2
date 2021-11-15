package Figures;

import java.awt.*;
import javax.swing.*;

public class Line extends Figure{
  private int x1, x2, y1, y2;
  public Line(int x, int y, int w, int h,
  int rC, int gC, int bC){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;

    this.x1 = x;
    this.y1 = y;

    this.x2 = x + w;
    this.y2 = y + h;

    this.rC = rC;
    this.gC = gC;
    this.bC = bC;
  }

  public void paint(Graphics g, boolean selected){
    Graphics2D g2d = (Graphics2D) g;

    if(selected){
        g2d.setColor(Color.RED);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }
    
    g2d.setColor(new Color(this.rC, this.gC, this.bC));
    g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
  }

  public boolean clicked(int pX, int pY){
    return ((pX >= this.x && pX <= (this.x + this.w)) && (pY >= this.y && pY <= (this.y + this.h)));
  }

  public void newPos(){
    this.x1 = x;
    this.y1 = y;

    this.x2 = x + w;
    this.y2 = y + h;
  }
}
