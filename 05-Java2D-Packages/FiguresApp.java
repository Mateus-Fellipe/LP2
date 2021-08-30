import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Figures.*;

class FiguresApp{
  public static void main (String[] args) {
    FiguresFrame Frame = new FiguresFrame();
    Frame.setVisible(true);
  }
}


class FiguresFrame extends JFrame{
  Rect r1;
  Elipse e1;
  Circle c1;

  FiguresFrame(){
    this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);

        this.r1 = new Rect(75, 50, 150, 100,
        255, 0, 0,
        255, 153, 0
        );

        this.e1 = new Elipse(50, 150, 100, 50,
        216, 113, 221,
        255, 153, 0
        );

        this.c1 = new Circle(200, 200, 100,
        212, 255, 24,
        122, 11, 27);
  }
  public void paint(Graphics g){
    super.paint(g);
    this.r1.paint(g);
    this.e1.paint(g);
    this.c1.paint(g);
  }
}
