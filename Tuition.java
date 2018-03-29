import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Tuition {
    public static void calculateTuition() {
            JFrame frame = new JFrame(); //Create the frame
            frame.setSize(500, 500); //Set frame size
            frame.setBackground(Color.GRAY);//Set the color
            
            // User inputs information(credits,cost per credit, parking costs, cost of textbooks)
            String fullName;
            fullName = JOptionPane.showInputDialog("What is your full name?");
            
            String creditString;
            creditString = JOptionPane.showInputDialog("How many credits are you taking this semester?");
            
            String costString;
            costString = JOptionPane.showInputDialog("What is the cost per credit?");
            
            String bookString;
            bookString = JOptionPane.showInputDialog("How much money will you spend on textbooks this semester?");
            
            String parkingString;
            parkingString = JOptionPane.showInputDialog("How much will you spend on parking this semester?");
            
            //Program converts strings into integers and doubles.
            int credit;
            double cost;
            double books;
            double parking;
            credit = Integer.parseInt(creditString);//Credit is an integer because the value must be a whole number.
            cost = Double.parseDouble(costString); 
            books = Double.parseDouble(bookString);
            parking = Double.parseDouble(parkingString);
            double costOfCredits;
            double Total;
            costOfCredits = credit * cost;
            
            Total = costOfCredits + books + parking;
            //Program converts the doubles to valid numbers with two decimal placings.
            String validTotal;
            String validCost;
            String validBooks;
            String validParking;
            validTotal = String.format("%.2f", Total);
            validCost = String.format("%.2f", cost);
            validBooks = String.format("%.2f", books);
            validParking = String.format("%.2f", parking);
            
            
            
            
            Panel p = new Panel();
            p.setLayout (new GridLayout(4,4,0,0));
            JLabel labe = new JLabel("Tuition Calculator for " + fullName);
            JLabel label = new JLabel("Number of credits: " + credit);
            JLabel label2 = new JLabel("Cost per credit: $" + validCost);
            JLabel label3 = new JLabel("Total cost for textbooks: $" + validBooks);
            JLabel label4 = new JLabel("Total cost for parking: $" + validParking);
            JLabel label5 = new JLabel("Total cost of tuition: $" + validTotal);
            p.add(labe);
            p.add(label);
            p.add(label2);
            p.add(label3);
            p.add(label4);
            p.add(label5);
            label.setPreferredSize(new Dimension(100,100));
            
            
            //The following lines of code are for importing an image onto the application
            ImageIcon image = new ImageIcon("/Users/hanadm/Desktop/schoolEmblem.png");
            JLabel imageLabel = new JLabel(image); 
            p.add(imageLabel);
            imageLabel.setBounds(10, 10, 300, 300);
            imageLabel.setVisible(true);
            
            

            

            frame.setContentPane(p);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            

            
    }
}