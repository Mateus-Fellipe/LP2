package Figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;


public class Ellipese extends Figure{
  private Ellipse2D polygon;
  
  public Ellipese (int x, int y, int w, int h,
  int rF, int gF, int bF,
  int rC, int gC, int bC){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.rF = rF;
    this.gF = gF;
    this.bF = bF;
    this.rC = rC;
    this.gC = gC;
    this.bC = bC;
    
    this.polygon = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
    }

  public void paint(Graphics g, boolean selected){
    Graphics2D g2d = (Graphics2D) g;

    if (selected){
        g2d.setColor(Color.red);
        g2d.draw(new Ellipse2D.Double(this.x - 1, this.y - 1, this.w + 2, this.h + 2));
    }

    g2d.setColor(new Color(this.rF, this. gF, this.bF));
    g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

    g2d.setColor(new Color(this.rC, this. gC, this.bC));
    g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
  }

  public boolean clicked(int pX, int pY){
    if (this.polygon.contains(pX, pY)){    
                return true;
        } else { return false; }
    }

  public void newPos(){
    this.x = x;
    this.y = y;

    this.polygon = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
  }
}
