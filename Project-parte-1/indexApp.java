import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

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
    int pX, pY;

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
                    Point posMouse = getMousePosition();

                    if((posMouse.x >= 0 && posMouse.x <= 500) && (posMouse.y >= 0 && posMouse.y <= 500)){
                        int x = posMouse.x;
                        int y = posMouse.y;
                        int w = rand.nextInt(150);
                        int h = rand.nextInt(150);
                        int r = rand.nextInt(255);
                        int g = rand.nextInt(255);
                        int b = rand.nextInt(255);
                        select = new Select(0,0,0,0);

                        switch(press.getKeyChar()){ // Entrada do teclado
                            case ('r'): // add rectangle
                              figs.add(new Rect(x, y, w, h, r, g, b, 0, 0, 0));
                              break;
                            case ('e'): // add elipse
                              figs.add(new Ellipese(x, y, w, h, r, g, b, 0, 0, 0));
                              break;
                            case ('t'): // add triangle
                              figs.add(new Triangle(x, y, w, h, r, g, b, 0, 0, 0));
                              break;
                            case ('l'): // add Line
                              figs.add(new Line(x, y, w, h, r, g, b));
                              break;
                        }

                        if(focus != null){
                            switch(press.getKeyChar()){
                                case ('f'): // remove figure
                                    figs.remove(focus);
                                    break;
                                case ('c'): // clean
                                    figs.removeAll(figs);
                                    break;
                                case ('a'): // arrow left
                                    focus.drag(28);
                                    select = new Select(focus.x, focus.y, focus.w, focus.h);
                                    break;
                                case ('d'): // arrow right
                                    focus.drag(29);
                                    select = new Select(focus.x, focus.y, focus.w, focus.h);
                                    break;
                                case ('w'): // arrow up
                                    focus.drag(30);
                                    select = new Select(focus.x, focus.y, focus.w, focus.h);
                                    break;
                                case ('s'): // arrow down
                                    focus.drag(31);
                                    select = new Select(focus.x, focus.y, focus.w, focus.h);
                                    break;
                            }
                        }
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
                    for (Figure fig: figs){
                        int pX = press.getX();
                        int pY = press.getY();
                        if ((pX >= fig.x && pX <= (fig.x + fig.w)) && ((pY >= fig.y && pY <= (fig.y + fig.h)))) {
                          focus = fig;
                        }
                    }
                    if(focus != null){
                      select = new Select(focus.x, focus.y, focus.w, focus.h);
                      figs.add(focus);
                      figs.remove(focus);
                      pX = press.getX() - focus.x;
                      pY = press.getY() - focus.y;
                    }
                    repaint();
                }
            }
        );

        this.addMouseMotionListener(
          new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent evt){

              if(focus != null){
                  focus.x = evt.getX() - pX;
                  focus.y = evt.getY() - pY;
                  select = new Select(0,0,0,0);
                  focus.newPos();
                  repaint();
              } else {;}
              select = new Select(focus.x, focus.y, focus.w, focus.h);
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
