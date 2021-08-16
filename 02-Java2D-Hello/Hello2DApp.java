import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 275);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        getContentPane().setBackground(Color.green);

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        g2d.setPaint(Color.yellow);
        g2d.fillRect(50, 75, 250, 150);

        g2d.setPaint(Color.blue);
        g2d.fillOval(w/2 - 50, h/2 - 35, 100, 100);


    }
}
