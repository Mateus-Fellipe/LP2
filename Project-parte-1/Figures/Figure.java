package Figures;

import java.awt.Graphics;
import ivisible.IVisible;
import java.io.Serializable;


public abstract class Figure implements IVisible, Serializable{
  public int x, y;
  public int w, h;
  protected int rC,gC,bC;
  protected int rF,gF,bF;


  public abstract void paint(Graphics g, boolean selected);
  public abstract void newPos();
  public void drag(int dir){
    if (dir == 28){
      this.x = this.x - 2;
    } else if (dir == 29){
      this.x = this.x + 2;
    } else if (dir == 30){
      this.y = this.y - 2;
    } else{
      this.y = this.y + 2;
    }
  }
}
