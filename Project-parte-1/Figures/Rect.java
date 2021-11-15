package Figures;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;


public class Rect extends Figure{
    private Rectangle2D polygon;
    
    public Rect (int x, int y, int w, int h,
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
        
        this.polygon = new Rectangle2D.Double(x, y, w, h);
     }


    public void paint(Graphics g, boolean selected){
        Graphics2D g2d = (Graphics2D) g;
        
        if(selected){
            g2d.setColor(Color.RED);
            g2d.drawRect(this.x - 1, this.y - 1, this.w + 2, this.h + 2);
        }

        g2d.setColor(new Color(this.rF, this.gF, this.bF));
        g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setColor(new Color(this.rC, this.gC, this.bC));
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }
    
    public boolean clicked(int pX, int pY){
      if(this.polygon.contains(pX, pY)){
            return true;
        } else {return false;}
    }

    public void newPos(){
        this.x = x;
        this.y = y;

        this.polygon = new Rectangle2D.Double(x, y, w, h);
    }
}
