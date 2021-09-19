package Figures;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Triangle extends Figure{
  private int x1, x2, x3, y1, y2, y3;

  public Triangle(int x1, int y1, int x2, int y2, int x3, int y3,
  int rF, int gF, int bF,
  int rC, int gC, int bC){
    this.x1 = x1;
    this.x2 = x2;
    this.x3 = x3;
    this.y1 = y1;
    this.y2 = y2;
    this.y3 = y3;

    this.rF = rF;
    this.gF = gF;
    this.bF = bF;
    this.rC = rC;
    this.gC = gC;
    this.bC = bC;
  }


  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;

    int[] x = {this.x1, this.x2, this.x3};
    int[] y = {this.y1, this.y2, this.y3};


    g2d.setColor(new Color(this.rF, this.gF, this.bF));
    g2d.fillPolygon(x, y, 3);

    g2d.setColor(new Color(this.rC, this.gC, this.bC));
    g2d.drawPolygon(x, y, 3);
  }
}
