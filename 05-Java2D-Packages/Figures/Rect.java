package Figures;

import java.awt.*;
import javax.swing.*;


public class Rect{
     private int x, y;
     private int w, h;
     private int rP, gP, bP;
     private int rD, gD, bD;

     public Rect (int x, int y, int w, int h,
     int rP, int gP, int bP,
     int rD, int gD, int bD){
         this.x = x; //Propriedades
         this.y = y;
         this.w = w;
         this.h = h;
         this.rP = rP;
         this.gP = gP;
         this.bP = bP;
         this.rD = rD;
         this.gD = gD;
         this.bD = bD;
     }

    public void paint (Graphics g){
      Graphics2D g2d = (Graphics2D) g;

      g2d.setColor(new Color(this.rP, this.gP, this.bP));
      g2d.fillRect(this.x, this.y, this.w, this.h);

      g2d.setColor(new Color(this.rD, this.gD, this.bD));
      g2d.drawRect(this.x, this.y, this.w, this.h);
    }
}
