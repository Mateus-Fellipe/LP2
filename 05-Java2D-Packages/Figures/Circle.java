package Figures;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Circle{
  private int x, y, radius;
  private int rF, gF, bF;
  private int rC, gC, bC;

  public Circle (int x, int y, int radius,
  int rF, int gF, int bF,
  int rC, int gC, int bC){
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.rF = rF;
    this.gF = gF;
    this.bF = bF;
    this.rC = rC;
    this.gC = gC;
    this.bC = bC;
  }

  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(new Color(this.rF, this.gF, this.bF));
    g2d.fillOval(this.x, this.y, this.radius, this.radius);

    g2d.setColor(new Color(this.rC, this.gC, this.bC));
    g2d.drawOval(this.x, this.y, this.radius, this.radius);
  }
}
