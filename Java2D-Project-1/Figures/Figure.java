package Figures;

import java.awt.Graphics;


public abstract class Figure{ // super classe e classe abstrata
  int x, y;
  int rF, gF, bF;
  int rC, gC, bC;

  public abstract void paint(Graphics g);
}
