package Figures;

import java.awt.Graphics;


public abstract class Figure{
  public int x, y;
  public int w, h;
  int rC,gC,bC;
  int rF,gF,bF;

  public abstract void paint(Graphics g);
  public abstract void drag(int dir);
  public abstract void newPos();
}
