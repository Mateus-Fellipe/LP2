package Figures;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Triangle extends Figure{
    private int x1, x2, x3, y1, y2, y3;
    private int lX [], lY[], listXSelected [], listYSelected [];
    private Polygon poligono, polygonSelected;

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
        
        int [] xSelected = {x1-1, x2, x3+1};
        int [] ySelected = {y1+1, y2-1, y3+1};
        this.listXSelected = xSelected;
        this.listYSelected = ySelected;

        this.polygonSelected = new Polygon(this.listXSelected, this.listYSelected, 3);
    }

    public void paint(Graphics g, boolean selected){
        Graphics2D g2d = (Graphics2D) g;
        
        if(selected){
            g2d.setColor(Color.RED);                    
            g2d.drawPolygon(polygonSelected);
        }
        
        g2d.setColor(new Color(this.rF, this.gF, this.bF));
        g2d.fillPolygon(poligono);

        g2d.setColor(new Color(this.rC, this.gC, this.bC));
        g2d.drawPolygon(poligono);
      }

    public boolean clicked(int pX, int pY){
      if (this.poligono.contains(pX, pY)){
            return true;    
        } else {return false;}
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
        
        int [] xSelected = {x1-1, x2, x3+1};
        int [] ySelected = {y1+1, y2-1, y3+1};
        this.listXSelected = xSelected;
        this.listYSelected = ySelected;

        this.polygonSelected = new Polygon(this.listXSelected, this.listYSelected, 3);
    }
}
