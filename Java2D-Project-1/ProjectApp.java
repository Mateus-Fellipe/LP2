import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import Figures.*;

public class ProjectApp{
  public static void main(String [] args){
    FrameApp Frame = new FrameApp();
    Frame.setVisible(true);
  }
}

class FrameApp extends JFrame{
  ArrayList<Figure> figs = new ArrayList<Figure>();
  Random rand = new Random();


  public FrameApp(){

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
            figs.add(new Rect(rand.nextInt(350), rand.nextInt(350), rand.nextInt(150), rand.nextInt(150),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

            repaint();
          }

          else if(press.getKeyChar() == 'e'){
            figs.add(new Ellipese(rand.nextInt(350), rand.nextInt(350), rand.nextInt(150), rand.nextInt(150),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

            repaint();
          }

          else if(press.getKeyChar() == 't'){
            figs.add(new Triangle(
            rand.nextInt(350), rand.nextInt(350),
            rand.nextInt(500), rand.nextInt(500),
            rand.nextInt(500), rand.nextInt(500),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255),
            rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            repaint();
          }

          else if(press.getKeyChar() == 'c'){
            figs.removeAll(figs);
            repaint();
          }
        }
      }
    );


    this.setTitle("Projeto 01");
    this.setSize(500, 500);
  }

  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g);

    for(Figure f: this.figs){
      f.paint(g);
    }
  }
}
