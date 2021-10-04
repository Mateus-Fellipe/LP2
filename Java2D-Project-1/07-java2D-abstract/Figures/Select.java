package Figures;

import java.awt.*;
import javax.swing.*;


public class Select extends Figure{
    public Select (int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

     }


    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawRect(this.x, this.y, this.w, this.h);
    }

    public void drag(int dir){}
    public void newPos(){}
}
