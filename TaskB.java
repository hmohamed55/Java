/*
 * Author: Hanad Mohamed
 * Programming Assignment 1
 * Task B
 */


import java.util.Scanner;


public class TaskB {
    
    public static void main(String [] args) {
        System.out.print("Enter a word: ");
        Scanner so = new Scanner(System.in);
        String word = so.nextLine();
        String[] chars = word.split("");
        
        System.out.println("The entered word is: " + word);
        

        byte[] uniCode=word.getBytes(); 
        System.out.println("The unicode values for the string is: ");
        for(int i=0;i<uniCode.length;i++){  
        System.out.println(uniCode[i]+" ");  }
        
        String backwards = new StringBuffer(word).reverse().toString();
        
        if (word.equalsIgnoreCase(backwards)) {
            System.out.println("The word is a palindrome");
        }
        else {
            System.out.println("The word is not a palindrome");
        }
        System.out.println("The values in ascending order are: ");
        sort(uniCode);
        for(int i=0;i<uniCode.length;i++){  
        System.out.println(uniCode[i]+" ");  }
        
        System.out.println("The max byte is: "+uniCode[uniCode.length-1]);
        System.out.println("The min byte is: " + uniCode[0]);
        int x = uniCode[0];
        int j = 0;
        int r = uniCode.length-1;
        for(j = 0; j <uniCode.length -1; j++) {
           x = x + uniCode[j];
           
       }
        System.out.println("The sum of the values is: " + x);
        System.out.println("The average of the values is: " + x/r);
 }  
    public static void sort(byte[] num) {
          int j;
             boolean numbers = true;   // set flag to true to begin first pass
             byte hold;   //holding variable

             while ( numbers )
             {
                    numbers= false;    //set flag to false awaiting a possible swap
                    for( j=0;  j < num.length -1;  j++ )
                    {
                           if ( num[ j ] > num[j+1] )   // change to > for ascending sort
                           {
                                   hold = num[ j ];                //swap elements
                                   num[ j ] = num[ j+1 ];
                                   num[ j+1 ] = hold;
                                  numbers = true;              //shows a swap occurred  
                          } 
                    } 
              } 
        
    }
    public static void sum(byte[] num) {
       for(int i = 1; i <num.length -1; i++) {
           int x = num[0];
           x = x + num[i];
           
       }
       
       }
}

