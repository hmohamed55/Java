import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//This class creates the traffic signal;

class Signal extends JPanel{

    Color on;
    //The following lines of code size how big each circle is on the traffic light;
    int radius = 20;
    int border = 10;
    boolean change;

    Signal(Color color){
        on = color;
        change = true;
    }

    public void turnOn(boolean b){//The following lines of code enable the GUI to be painted again when a change occurs;
        change = b;
        repaint();        
    }

    public Dimension getPreferredSize(){//The following lines of code set the dimensions for the signal;
        int size = (radius+border)*2;
        return new Dimension( size, size );
    }

    public void paintComponent(Graphics g){//The following lines of code set the dimness of each light(When on/off);
        g.setColor( Color.black );
        g.fillRect(0,0,getWidth(),getHeight());

        if (change){
            g.setColor( on );
        } else {
            g.setColor( on.darker().darker().darker() );
        }
        g.fillOval( border,border,2*radius,2*radius );
    }
}