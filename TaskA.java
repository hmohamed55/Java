/*
 * Author: Hanad Mohamed
 * Programming Assignment 1
 * Task A
 */

import java.util.Scanner;

public class TaskA{
    public static void main(String [] args) {
    System.out.print("Enter a word: ");
    Scanner so = new Scanner(System.in);
    String word = so.nextLine();
    String[] chars = word.split("");
    
    System.out.println("The entered word is: " + word);
    
    char first = word.charAt(0);
    char last = word.charAt(word.length() - 1);
    
    System.out.println("The first letter of the entered word is: " + first);
    System.out.println("The last letter of the entered word is: " + last);
    
   
    } 

}