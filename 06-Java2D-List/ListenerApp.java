/*
O que fazer?
Montar um programa principal que desenhe retangulos se pressionado r, elipses se precinado e,
triangulos se precionado t e um dado texto se precionado s.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import Figures.*;

public class ListenerApp{
  public static void main(String [] args){
    AppFrame Frame = new AppFrame();
    Frame.setVisible(true);
  }
}

class AppFrame extends JFrame{
  ArrayList<Rect> listR = new ArrayList<Rect>();
  ArrayList<Ellipese> listE = new ArrayList<Ellipese>();
  Random rand = new Random();

  public AppFrame(){
    this.addWindowListener(
      new WindowAdapter(){
        public void windowClosing(WindowEvent e){
          System.exit(0);
        }
      }
    );

    this.addKeyListener(
      new KeyAdapter(){
        public void keyPressed(KeyEvent press){
          if (press.getKeyChar() == 'r'){
            listR.add(new Rect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(150), rand.nextInt(150),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255) ));

            repaint();
          }
        }
      }
    );

    this.addKeyListener(
      new KeyAdapter(){
        public void keyPressed(KeyEvent press){
          if (press.getKeyChar() == 'e'){
            listE.add(new Ellipese(rand.nextInt(500), rand.nextInt(500), rand.nextInt(150), rand.nextInt(150),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255) ));

            repaint();
          }
        }
      }
    );

    this.setTitle("Java 2D - Listener E Listas");
    this.setSize(500, 500);
  }

  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g);

    for(Rect r: this.listR){
      r.paint(g);
    }

    for(Ellipese e: this.listE){
      e.paint(g);
    }
  }
}
