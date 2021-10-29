import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

import Figures.*;


public class indexApp{
    public static void main(String[] args){
      FrameApp Frame = new FrameApp();
      Frame.setVisible(true);
    }
}

class FrameApp extends JFrame{
    ArrayList<Figure> figs = new ArrayList<Figure>(); // Lista homogenia de elementos. Nela estão contidas as figuras
    Random rand = new Random(); // Random
    Figure focus = null;
    Figure select = new Select(0,0,0,0);
    int posX, posY;

    public FrameApp(){
        this.addWindowListener( // Listener de janela, feito para ouvir certo ações para as janelas.
          new WindowAdapter(){
            public void windowClosing(WindowEvent ext){
              System.exit(0);
            }
          }
        );

        this.addKeyListener( // Listener de Teclado, feito para ouvir o teclado.
            new KeyAdapter(){
                public void keyPressed(KeyEvent press){
                    Point PosMouse = getMousePosition();
                    int x = PosMouse.x;
                    int y = PosMouse.y;
                    int w = rand.nextInt(150);
                    int h = rand.nextInt(150);
                    int r = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    select = new Select(0,0,0,0);

                    if (press.getKeyChar() == 'r'){ // add rectangle
                      figs.add(new Rect(x, y, w, h, r, g, b, 0, 0, 0));
                    }else if (press.getKeyChar() == 'e'){ // add elipse
                      figs.add(new Ellipese(x, y, w, h, r, g, b, 0, 0, 0));
                    }else if (press.getKeyChar() == 't'){ // add triangle
                      figs.add(new Triangle(x, y, w, h, r, g, b, 0, 0, 0));
                    }else if (press.getKeyChar() == 'l'){ // add Line
                      figs.add(new Line(x, y, w, h, r, g, b));
                    }else if (press.getKeyChar() == 'f'){ // remove figure
                      figs.remove(focus);
                    }else if (press.getKeyChar() == 'c'){ // clean
                      figs.removeAll(figs);
                    } else if (press.getKeyChar() == 'a'){ // arrow left
                      focus.drag(28);
                      select = new Select(focus.x, focus.y, focus.w, focus.h);
                    } else if (press.getKeyChar() == 'd'){ // arrow right
                      focus.drag(29);
                      select = new Select(focus.x, focus.y, focus.w, focus.h);
                    } else if (press.getKeyChar() == 'w'){ // arrow up
                      focus.drag(30);
                      select = new Select(focus.x, focus.y, focus.w, focus.h);
                    } else if (press.getKeyChar() == 's'){ // arrow down
                      focus.drag(31);
                      select = new Select(focus.x, focus.y, focus.w, focus.h);
                    }

                    repaint();
                }
            }
        );

        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent press){
                    focus = null;
                    select = new Select(0,0,0,0);

                    int pX = press.getX();
                    int pY = press.getY();
                    for (Figure fig: figs){
                        if (fig.clicked(pX, pY)) {
                          focus = fig;
                          posX = pX - focus.x;
                          posY = pY - focus.y;
                        }
                    }
                    if(focus != null){
                      select = new Select(focus.x, focus.y, focus.w, focus.h);
                      figs.add(focus);
                      figs.remove(focus);
                    }
                    repaint();
                }
            }
        );

        this.addMouseMotionListener(
          new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent evt){
              int pX = evt.getX(), pY = evt.getY();
              if(focus != null){
                  focus.x = pX - posX; // Posição do x da figure. pX é a posição do mouse.
                  focus.y = pY - posY;
                  select = new Select(0,0,0,0);
                  focus.newPos();
                  repaint();
                  select = new Select(focus.x, focus.y, focus.w, focus.h);
              }else{;}
            }
          }
        );

        this.setTitle("Projeto 1/2");
        this.setSize(500, 500);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);

        for(Figure f: this.figs){
            f.paint(g);
        }
        this.select.paint(g);
    }
}
