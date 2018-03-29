/*
*@(#)MilkyWay.Java
*
*MilkyWay Applet Application
*An applet to display the user's desired amount of planets in a galaxy
*This applet is displayed as a JFrame
*Required/Completed: Use of random numbers, events, loops.
*Extras: Changing color of font
*
*@Author: Hanad Mohamed
*@Version 1.00 2017/10/26
*/


//The following lines of code implement the necessary packages.
 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class star extends JFrame implements ActionListener{
    private JPanel p1;
    private JTextField text;
    private Random randomSpots;
    private JButton button;
    private JLabel label;
    private JPanel p2;

    

    
        
    
    public static void main(String[] args) {
        //The following lines create our JFrame;
        star frame = new star();
        frame.setSize(1000, 1000);
        frame.createGUI();
        frame.setVisible(true);
        frame.setResizable(false);
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new BorderLayout());//This line of code utilizes the BorderLayout
        
        p1 = new JPanel();//This creates the panel that the milky way will be displayed upon;
        p1.setPreferredSize(new Dimension(800, 800));
        p1.setVisible(true);
        p1.setBackground(Color.black);
        window.add(p1, BorderLayout.CENTER);
        
        p2= new JPanel();//This creates the panel where our JLabel and textfield will be displayed up;
        p2.setVisible(true);
        p2.setLayout(new FlowLayout());
        p2.setBackground(Color.white);
        window.add(p2, BorderLayout.PAGE_START);
        
        
        
        label = new JLabel("Enter the desired number of planets in your galaxy: ");
        label.setForeground(Color.blue);
        p2.add(label);
        
        text = new JTextField(20);//This line creates our textfield for user input, limiting the number of characters to 20
        p2.add(text);

        
        button = new JButton("Enter");//This line creates the button that wilLl trigger our event;
        button.addActionListener(this);
        window.add(button, BorderLayout.LINE_END);
        

        
        randomSpots = new Random();//This line of code creates our random instance;

        
        
        window.setVisible(true);
        
        
        
    
        
        
        
        
    }
    public void actionPerformed(ActionEvent event) {
       Graphics g = p1.getGraphics();
       g.fillRect(0, 0, 800, 800);

       
       String s;//This line retrieves the user's inputed information from the textField as a string;
       s = text.getText();
       
       int b;
       b = Integer.parseInt(s);//This line converts our string from the textField into an integer;
       for (int a = 0 ; a < b; a++) {
           int c, d, radius;

           //The following two lines place our planets at random locations across the panel;
           c = randomSpots.nextInt(600);
           d = randomSpots.nextInt(600);
           radius = randomSpots.nextInt(101);//This line selects a random number(0-100) as our radius since the max diameter is 200 pixels;
           
           /*The following lines of code manipulate colors by modifying the RBG value(Red,Green, and Blue intensity) to create colors. 
            * A random value is picked and multipled by 256 because color intensity is measured on a scale of 0-255;*/
           int R = (randomSpots.nextInt(256));
           int G = (randomSpots.nextInt(256));
           int B= (randomSpots.nextInt(256));
           Color color = new Color(R, G, B);
      
           g.setColor(color);
           g.fillOval(c, d, radius, radius);
           
       }
       }
}
