/*Fractal.java
 * 
 * Author: Hanad Mohamed
 * Date:March 26, 2018
 * 
 * This program displays a fractal
 * 
 * The following is a slight altercation of an image I selected from
 * one of my favorite comics growing up.
 * 
 * The colors of the fractal are randomized everytime the program runs.
 * 
 * Image Source: https://qph.fs.quoracdn.net/main-qimg-19753578fc0aae71fd4727f01de62e78.webp



*/
import java.awt.*;
import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Fractal extends JPanel {
    Graphics g;
    Random randomColor = new Random();
    
    public void drawShapes(int x, int y, int s) {
        if (s < 100) 
        { 
            if (s == 0) {
            
            g.setColor(Color.black);
            g.fillOval(260, 260, 75, 75);
            
            }
            else {
            return; 
        }
        } 
        else 
        {     
           int R = (randomColor.nextInt(256));
           int G = (randomColor.nextInt(256));
           int B= (randomColor.nextInt(256));
           Color color = new Color(R, G, B);
      
            
            
               g.setColor(Color.red);
               g.drawRect(x,y,s,s);
               
               g.setColor(color);
               g.fillOval(x,y,s,s);

               /**
                *The following segments of code utilize self similarity and scaling by
                *decreasing the square and circle dimensions by 100 pixels every
                *time you call this method
                */
               s = s - 100;   
               //The next line utilizes recursion by calling the drawShapes method within its own method
               drawShapes(x + 50, y + 50, s);
            }
         }   
    //The following lines of code utilize the graphics package to display our fractal
         public void paint(Graphics p) {
       g = p;
       setVisible(true);  
       drawShapes(0, 0, 600);
    }
    //The following lines of code create our JFrame and size it
    public static void main(String... args) {
        final JFrame frame = new JFrame("Assignment 5");
        SwingUtilities.invokeLater(new Runnable() {


            public void run() {
                frame.setContentPane(new Fractal());
                frame.setSize(600, 620);
                frame.setResizable(false);
                frame.setBackground(Color.gray);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setResizable(true);
                frame.setVisible(true);
            }
        });
    }
}



