//The following code is imports needed for the program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//This is the main class in the program

public class Light extends JFrame implements ActionListener{
      private JButton b1, b2, b3;//This creates the buttons the user will click;
      
      //The following lines of code create the traffic signal with its colors;
      Signal green = new Signal(Color.green);
      Signal yellow = new Signal(Color.yellow);
      Signal red = new Signal(Color.red);
      
      //This variable sets the starting point for the car image on the JFrame;
      private int x = 400;
      
      //The following lines of code insert the car image into a JLabel.
      ImageIcon image = new ImageIcon("car3.jpg");
      JLabel imagelabel = new JLabel(image);
      


      
      
      
      

public static void main(String[] args) {
    //The following lines of code create our JFrame
    Light frame = new Light();
    frame.setSize(500,500);
    frame.createGUI();
    frame.setVisible(true);
    frame.setResizable(false);//This line makes the JFrame non resizable;
}
private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(null);//This line sets the layout of the JFrame to null
    window.setBackground(Color.CYAN);
    

    //The following lines of code creates the buttons the user will click on and adds them to a JPanel;
    JPanel p1 = new JPanel(new GridLayout(1,3));
    
    b1 = new JButton("STOP");
    b2 = new JButton("SLOW DOWN");
    b3 = new JButton("GO");
    
    //The following lines set the font color for the buttons;
    b1.setForeground(Color.RED);
    b2.setForeground(Color.YELLOW);
    b3.setForeground(Color.GREEN);
    b1.setBackground(Color.BLACK);
    
    //The following lines of code add the actionListener to each button;
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this); 
    
    p1.add(b1);
    p1.add(b2);
    p1.add(b3);
    p1.setBounds(0, 0, 500, 50);
    p1.setBackground(Color.BLACK);
    
    //The following lines of code add the signals to a JPanel;
    
    JPanel p2 = new JPanel(new GridLayout(3,1));
    p2.add(red);
    p2.add(yellow);
    p2.add(green);
    p2.setBounds(440, 50, 100, 200);
    p2.setBackground(Color.BLACK);
    
    imagelabel.setBounds(x, 390, 100, 50);//This line sets the default position of the car image;
    imagelabel.setVisible(true);
    
    //The following lines of code create the road and position it towards the bottom of the screen;
    ImageIcon image2 = new ImageIcon("/Users/hanadm/Desktop/NewRoad.jpg");
    JLabel imageLabel2 = new JLabel(image2);
    imageLabel2.setBounds(0, 400, 500, 85);
    imageLabel2.setVisible(true);
    
    
    JPanel p3 = new JPanel();
    
    window.add(p1);
    window.add(p2);
    window.add(p3);
    
    //The following code adds the two images(car, road) to the Container;
    window.add(imagelabel);
    window.add(imageLabel2);

    
    p1.setVisible(true);
    p2.setVisible(true);

    //The following lines of code set the default signal to red(Stop);
    green.turnOn(false);
    yellow.turnOn(false);
    red.turnOn(true);//
}
public void actionPerformed(ActionEvent event) {
    if (event.getSource() == b1){//This is what is triggered when user clicks "Stop";
            green.turnOn(false);            
            yellow.turnOn(false);
            red.turnOn(true);
            x = x + 0;
            imagelabel.setBounds(x, 390, 100, 50);
            imagelabel.setVisible(true);
        } else if (event.getSource() == b2){//This is what is triggered when user clicks "Slow down";
            yellow.turnOn(true);            
            green.turnOn(false);
            red.turnOn(false);
            x = x - 20;//This line moves the car 20 pixels to the left.
            imagelabel.setBounds(x, 390, 100, 50);
            imagelabel.setVisible(true);
        } else if (event.getSource() == b3){//This is what is triggered when user clicks "Go";
            red.turnOn(false);            
            yellow.turnOn(false);
            green.turnOn(true);
            x = x - 100;//This line moves the car 100 pixels to the left.
            imagelabel.setBounds(x, 390, 100, 50);
            imagelabel.setVisible(true);
        } 
}
}
