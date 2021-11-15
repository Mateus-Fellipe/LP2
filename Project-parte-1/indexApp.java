import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.event.KeyEvent;

import Button.buttons;
import Figures.*;


public class indexApp{
    public static void main(String[] args){
      FrameApp Frame = new FrameApp();
      Frame.setVisible(true);
    }
}

class FrameApp extends JFrame{
    private ArrayList<Figure> figs = new ArrayList<Figure>(); // Lista homogenia de elementos. Nela estão contidas as figuras
    private ArrayList<buttons> butts = new ArrayList<buttons>() {{
    add(new buttons(0, new Rect(15, 45, 20, 20, 0,0,0,0,0,0)));
    add(new buttons(1, new Ellipese(15, 90, 20, 20, 0,0,0,0,0,0)));
    add(new buttons(2, new Triangle(15, 135, 20, 20, 0,0,0,0,0,0)));
    add(new buttons(3, new Line(15, 180, 20, 20, 0,0,0)));
    }}; 
    
    private Random rand = new Random(); // Random
    
    private Ellipese e = new Ellipese(0,0,0,0,0,0,0,0,0,0);
    private Rect rT = new Rect(0,0,0,0,0,0,0,0,0,0);
    private Triangle t = new Triangle(0,0,0,0,0,0,0,0,0,0);
    private Line l = new Line(0,0,0,0, 0,0,0);

    private Figure focusFig = null;
    private buttons focusBut = null;

    private int butSelected = -1;
    private int index = -1;
    private int posX, posY;

    public FrameApp(){
        try {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) o.readObject();
            o.close();
        } catch (Exception err) {
            System.out.format("Erro ao ler arquivo: %s\n", err.getMessage());
        }
        
        this.addWindowListener( // Listener de janela, feito para ouvir certo ações para as janelas.
          new WindowAdapter(){
            public void windowClosing(WindowEvent ext){
              try {
                   FileOutputStream f = new FileOutputStream("proj.bin");
                   ObjectOutputStream o = new ObjectOutputStream(f);
                   o.writeObject(figs);
                   o.flush();
                   o.close();
               } catch (Exception err) {
                System.out.format("Erro ao salvar arquivo: %s\n", err.getMessage());
               }
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

                    if (press.getKeyChar() == 'r'){ // add rectangle
                      figs.add(new Rect(x, y, w, h, r, g, b, 0, 0, 0));
                      index = figs.size();
                      focusFig = figs.get(index - 1);
                    }else if (press.getKeyChar() == 'e'){ // add elipse
                      figs.add(new Ellipese(x, y, w, h, r, g, b, 0, 0, 0));
                      index = figs.size();
                      focusFig = figs.get(index - 1);
                    }else if (press.getKeyChar() == 't'){ // add triangle
                      figs.add(new Triangle(x, y, w, h, r, g, b, 0, 0, 0));
                      index = figs.size();
                      focusFig = figs.get(index - 1);
                    }else if (press.getKeyChar() == 'l'){ // add Line
                      figs.add(new Line(x, y, w, h, r, g, b));
                      index = figs.size();
                      focusFig = figs.get(index - 1);
                    }else if (press.getKeyChar() == 'f'){ // remove figure
                      figs.remove(focus);
                    }else if (press.getKeyChar() == 'c'){ // clean
                      figs.removeAll(figs);
                    } else if (press.getKeyChar() == 'a'){ // arrow left
                      focus.drag(28);
                    } else if (press.getKeyChar() == 'd'){ // arrow right
                      focus.drag(29);
                    } else if (press.getKeyChar() == 'w'){ // arrow up
                      focus.drag(30);
                    } else if (press.getKeyChar() == 's'){ // arrow down
                      focus.drag(31);
                    }

                    repaint();
                }
            }
        );

        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent press){
                    focusFig = null;
                    focusBut = null;
                    int w = rand.nextInt(150);
                    int h = rand.nextInt(150);
                    int r = rand.nextInt(255);         
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    
                    int pX = press.getX();
                    int pY = press.getY();
                    
                    for (Figure fig: figs){
                        if (fig.clicked(pX, pY)) {
                          focusFig = fig;
                          posX = pX - focusFig.x;
                          posY = pY - focusFig.y;
                        }
                    }
                    if(focus != null){
                      figs.add(focusFig);
                      figs.remove(focusFig);
                    }
                    
                    for(buttons but: butts){
                        if(but.clicked(pX, pY)){
                            focusBut = but;
                        } 
                    }

                    if (butts.indexOf(focusBut) == 0){
                        butSelected = 0;
                    } else if (butts.indexOf(focusBut) == 1) {
                        butSelected = 1;
                    } else if (butts.indexOf(focusBut) == 2) {
                        butSelected = 2;
                    } else if (butts.indexOf(focusBut) == 3){
                        butSelected = 3;
                    } else {
                        if(butSelected == 0){
                            figs.add(new Rect(pX, pY, w, h, r, g, b,0,0,0));
                            index = figs.size();
                            focusFig = figs.get(index - 1);
                        } else if (butSelected == 1) {
                            figs.add(new Ellipese(pX, pY, w, h, r, g, b,0,0,0));
                            index = figs.size();
                            focusFig = figs.get(index - 1);
                        } else if (butSelected == 2) {
                            figs.add(new Triangle(pX, pY, w, h, r, g, b,0,0,0));
                            index = figs.size();
                            focusFig = figs.get(index - 1);
                        } else if (butSelected == 3) {
                            figs.add(new Line(pX, pY, w, h, r, g, b));
                            index = figs.size();
                            focusFig = figs.get(index - 1);
                        }
                        butSelected = -1;
                    }
                    
                    repaint();
                }
            }
        );

        this.addMouseMotionListener(
          new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent evt){
              int pX = evt.getX(), pY = evt.getY();
              if(focusFig != null){
                  focusFig.x = pX - posX; // Posição do x da figure. pX é a posição do mouse.
                  focusFig.y = pY - posY;
                  focusFig.newPos();
                  repaint();
              }else{;}
            }
          }
        );

        this.setTitle("Final project");
        this.setSize(500, 500);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);

        for(Figure f: figs){
            if (focusFig == f){
                f.paint(g, true);
            } else {
                f.paint(g, false);
            }
        }

        for(buttons but: butts){
            if(focusBut == but){
                but.paint(g, true);
            } else {
                but.paint(g, false);
            } 
        
        }
    }
}
