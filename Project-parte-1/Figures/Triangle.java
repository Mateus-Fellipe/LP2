package Figures;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Triangle extends Figure{
    public int x1, x2, x3, y1, y2, y3;
    public int lX [], lY[];
    private Polygon poligono;

    public Triangle(int x, int y, int w, int h,
    int rF, int gF, int bF,
    int rC, int gC, int bC){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.x1 = x;
        this.y1 = y + h;

        this.x2 = x + w / 2;
        this.y2 = y;

        this.x3 = x + w;
        this.y3 = y + h;

        this.rF = rF;
        this.gF = gF;
        this.bF = bF;
        this.rC = rC;
        this.gC = gC;
        this.bC = bC;

        int [] listX = {x1, x2, x3};
        int [] listY = {y1, y2, y3};
        this.lX = listX;
        this.lY = listY;

        this.poligono = new Polygon(this.lX, this.lY, 3);
    }

    public void paint(Graphics g){
        int[] x = {this.x1, this.x2, this.x3};
        int[] y = {this.y1, this.y2, this.y3};
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(this.rF, this.gF, this.bF));
        g2d.fillPolygon(poligono);

        g2d.setColor(new Color(this.rC, this.gC, this.bC));
        g2d.drawPolygon(poligono);
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

    public boolean clicked(int pX, int pY){
      return ((pX >= this.x && pX <= (this.x + this.w)) && (pY >= this.y && pY <= (this.y + this.h)));
    }

    public void newPos(){
        this.x1 = x;
        this.y1 = y + h;

        this.x2 = x + w / 2;
        this.y2 = y;

        this.x3 = x + w;
        this.y3 = y + h;

        int [] listX = {x1, x2, x3};
        int [] listY = {y1, y2, y3};
        this.lX = listX;
        this.lY = listY;

        this.poligono = new Polygon(this.lX, this.lY, 3);
    }
}
