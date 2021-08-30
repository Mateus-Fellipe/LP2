import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;


class ElipseApp{
  public static void main(String[] args){
    FiguresFrame Frame = new FiguresFrame();
    Frame.setVisible(true);
  }
}


class Elipse{
  private int x, y;
  private int w, h;
  private int rF, gF, bF;
  private int rC, gC, bC;

  Elipse(int x, int y, int w, int h,
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

  void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(new Color(this.rF, this. gF, this.bF));
    g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

    g2d.setColor(new Color(this.rC, this. gC, this.bC));
    g2d.draw(new Ellipse2D.Double(this.x, this.y, this.w, this.h));

  }

}


class FiguresFrame extends JFrame{
  Elipse e1, e2, e3;
  public FiguresFrame () {
      this.addWindowListener (
          new WindowAdapter() {
              public void windowClosing (WindowEvent e) {
                  System.exit(0);
              }
          }
      );
      this.setTitle("Java2D - Elipses");
      this.setSize(350, 350);
      this.e1 = new Elipse(125, 150, 100, 50,
      216, 113, 221,   //Preenchimento
      255, 153, 0 // Borda
      );

      this.e2 = new Elipse(0, 25, 125, 100,
      124, 217, 112,
      211, 158, 212);

      this.e3 = new Elipse(200, 200, 100, 125,
      111, 0, 217,
      255, 212, 11);
  }

  public void paint(Graphics g){
    getContentPane().setBackground(Color.black);
    super.paint(g);
    this.e1.paint(g);
    this.e2.paint(g);
    this.e3.paint(g);
  }
}
