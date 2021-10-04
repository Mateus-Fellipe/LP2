package Figures;

import java.awt.*;
import javax.swing.*;


public class Rect extends Figure{
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
     }

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

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rF, this.gF, this.bF));
        g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setColor(new Color(this.rC, this.gC, this.bC));
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }

    public void newPos(){}
}
