/*
 * Author: Hanad Mohamed
 * Programming Assignment 1
 * Task C
 */

import java.util.Scanner;

public class TaskC
{
   public static void main(String args[])
   {
        int m, j, r;
        String word;
        char alpha, letter;
        Scanner so = new Scanner(System.in);
        

        System.out.print("Enter a word : ");
        word=so.nextLine();
       

        
        m=word.length();
        for(alpha='A'; alpha<='z'; alpha++)
        {
            r=0;
            for(j=0; j<m; j++)
            {
                letter = word.charAt(j);
                if(letter == alpha)
                {
                    r++;
                    
                }
            }
            if(r>0)
            {   System.out.println("The letter: " +alpha+ " has a frequency of: " + r);

            }
        }
   }
}