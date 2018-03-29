//The following lines of code implement the necessary packages for our program;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Smiley extends JPanel{
Color color1;
Color color2;
Color color3;
Color color4; 

//The following is the constructor for my Smiley face.  The parameters are the 4 colors used in each smiley;
public Smiley(Color eyesColor, Color smileColor, Color outlineColor, Color skinColor) 
    {color1 = eyesColor;
     color2 = smileColor;
     color3 = outlineColor;
     color4 = skinColor;
    }
//The following utilizes the paintComponent, which will be used to draw our smiley using the our constructor;
public void paintComponent(Graphics g) {
  g.setColor(color3);
  g.drawOval(0,0,200,200);   // For face outline
  g.setColor(color4);       
  g.fillOval(0, 0, 200, 200);   //Skin color
  g.setColor(color1);
  g.fillOval(110,60,30,50);     // Left Eye 
  g.fillOval(50,60,30,50);      //Right eye
  g.setColor(color2);
  g.fillArc(65,120,60, 40, 0, -180); //Smile
}
}



