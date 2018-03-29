/*
 *a(#)Dictionary.java
 *
 *Dictionary Applet Application 
 *An applet to translate a word from English to Somali or Somali to English and to display an Image of that word.
 *This Applet is displayed as a JFrame.
 *Required/Completed: Array of English words; Array of words from language of your choice; Array of images.
 *Extras: None.
 *
 *Author: Hanad Mohamed
 *@Version 1.0.0 2017/12/6
 */




//The following lines of code implement the packages necessary for our application;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class translator extends JFrame implements ActionListener{
    private JLabel title;
    private JPanel p1, p2, p3, p4;
    private JTextField text, results;
    private JLabel enter,exit, flagPic, flagPic2, vocab, vocab2;
    private JButton translate, image;
    private String [] english = {"tea", "car", "door","chair", "window", "telephone", "wall", "cat", "police", "backpack"};
    private String [] somali = {"shaah", "gaari", "albaab", "kursi", "daaqad", "talafoonka", "dirbi", "yaanyuur", "askari", "boorso" };
    private ImageIcon flag, flag2;
    private ImageIcon [] pics = new ImageIcon[10];
    private JTextArea selection, selection2;
    private int index = 0;
    
    
    //The following lines of code create our JFrame;
    public static void main(String[] args){
        translator frame = new translator();
        frame.setSize(900, 900);
        frame.createGUI();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Hanad's Dictionary Project");
    }
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new BorderLayout());//This line sets our JFrame to use the BorderLayout;
        window.setBackground(Color.white);
        
        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(900, 50));
        p1.setVisible(true);
        p1.setBackground(Color.cyan);
        window.add(p1, BorderLayout.PAGE_START);
        
        //This panel is the header for out JFrame;
        title = new JLabel("Hanad's English to Somali Dictionary");
        title.setForeground(Color.black);
        p1.add(title);
        
        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(300, 850));
        p2.setVisible(true);
        p2.setBackground(Color.cyan);
        window.add(p2, BorderLayout.LINE_START);
        
        enter = new JLabel("Enter a word: ");
        enter.setForeground(Color.black);
        p2.add(enter);
        
        text = new JTextField(20);
        p2.add(text);
        
        translate = new JButton("Translate");
        p2.add(translate);
        translate.addActionListener(this);
        
        vocab = new JLabel("Select from the following English words: ");
        p2.add(vocab);
        //The following lines of code display the words the user may select from in english;
        selection = new JTextArea(9, 9);
        selection.setEditable(false);
        selection.setBackground(Color.cyan);
        p2.add(selection);
        //The following loop adds all the words in our english array to the JTextArea;
        for (index = 0; index!= english.length; index++) {
            selection.append(english[index] + "\r\n");
        }
        
        vocab2 = new JLabel("Select from the following Somali words: ");
        p2.add(vocab2);
        //The following lines of code display the words the user may select from in somali;
        selection2 = new JTextArea(9, 9);
        selection2.setEditable(false);
        selection2.setBackground(Color.cyan);
        p2.add(selection2);
        //The following loop adds all the words in our somali array to the JTextArea;
        for (index = 0; index!= somali.length; index++) {
            selection2.append(somali[index] + "\r\n");
        }
        
        

        
        p3 = new JPanel();
        p3.setPreferredSize(new Dimension(300, 850));
        p3.setBackground(Color.cyan);
        p3.setVisible(true);
        window.add(p3, BorderLayout.LINE_END);
        //The following lines of code add our images to the pics array;
        pics [0] = new ImageIcon("tea.jpg");
        pics [1] = new ImageIcon("car.jpg");
        pics [2] = new ImageIcon("door.jpg");
        pics [3] = new ImageIcon("chair.jpg");
        pics [4] = new ImageIcon("window.jpg");
        pics [5] = new ImageIcon("telephone.jpg");
        pics [6] = new ImageIcon("wall.jpg");
        pics [7] = new ImageIcon("cat.jpg");
        pics [8] = new ImageIcon("police.jpg");
        pics [9] = new ImageIcon("backpack.jpg");
        
        exit = new JLabel("Translation:");
        p3.add(exit);
        
        results = new JTextField(20);
        results.setBackground(Color.white);
        results.setEditable(false);
        p3.add(results);
        //The following lines of code create the JButton that shall display our Images;
        image = new JButton();
        p3.add(image);
        image.setVisible(false);
        
        p4 = new JPanel();
        p4.setPreferredSize(new Dimension(300, 850));
        p4.setBackground(Color.cyan);
        p4.setVisible(true);
        window.add(p4, BorderLayout.CENTER);
        //The following lines of code add our American and Somali Flag to our center panel;
        flag = new ImageIcon("SomaliFlag.jpg");
        flagPic = new JLabel(flag);
        p4.add(flagPic);
        
        flag2 = new ImageIcon("americanflag.jpg");
        flagPic2 = new JLabel(flag2);
        p4.add(flagPic2);
        

        
        
        window.setVisible(true);
    }
    //The following lines of code set our ActionListener to trigger the method "translate";
    public void actionPerformed(ActionEvent event){
    translate();
    }
    //The following method translates Somali words entered by the user into english;
    public void translate() {
    int index;
    String word;
    
    word = text.getText();
    index = 0;
    //The following lines of code utilize a for loop to to match the user inputed word to a word in the Somali Array; 
        for (index = 0;
        !(somali[index].equalsIgnoreCase(word)) && (index!=(somali.length-1));
        index++) { }
    //The following if statements only displays a translation if the user inputed words is the same as a word in the Somali Array;
        if (somali[index].equalsIgnoreCase(word)) {
            results.setText("The word in english is: " + english[index]);
            image.setVisible(true);
            image.setIcon(pics[index]);//This line displays the image of the translated word;
        } 
        //The following utilizes our reverseTranslate method if the previous condition is not met;
        else  {
            reverseTranslate();
        }
    
    }
    //The following method translates English words entered by the user into Somali;
    private void reverseTranslate() {
    String word1;
    word1 = text.getText();
    for (index = 0;
        !(english[index].equalsIgnoreCase(word1)) && (index!=(english.length-1));
        index++) { }
    if (english[index].equalsIgnoreCase(word1)) {
        results.setText("The word in Somali is: " + somali[index]);
        image.setVisible(true);
        image.setIcon(pics[index]);//This line displays the image of the translated word;
    } 
    //The following lines of code display a message if the word is not found;
    else  {
    JOptionPane.showMessageDialog(null, "Word is not found! \n" + "Please enter a word from the displayed selection");//The message is displayed in a JOptionPane.
    results.setText("");
    image.setVisible(false);
    }
    
    }
    
    

}