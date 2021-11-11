package Figures;

import java.awt.Graphics;
import ivisible.IVisible;


public abstract class Figure implements IVisible{
  public int x, y;
  public int w, h;
  protected int rC,gC,bC;
  protected int rF,gF,bF;



  public abstract void paint(Graphics g);
  public abstract void drag(int dir);
  public abstract void newPos();
}
