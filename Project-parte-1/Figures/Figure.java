package Figures;

import java.awt.Graphics;
import ivisible.IVisible;
import java.io.Serializable;


public abstract class Figure implements IVisible, Serializable{
  protected int x, y;
  protected int w, h;
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
    } else{ this.y = this.y + 2; }
  }
  
  public int getterX(){ return x; }
  
  public int getterY(){ return y; }

  public void setterX(int aux){ this.x = aux; }

  public void setterY(int aux){ this.y = aux; }
  
  public void setterW(int aux){ this.w = aux; }
  
  public void setterH(int aux){ this.h = aux; }
}
