package Figures;

import java.awt.Graphics;


public abstract class Figure{
  int x, y;
  int rC,gC,bC;
  int rF,gF,bF;

  public abstract void paint(Graphics g);
}
