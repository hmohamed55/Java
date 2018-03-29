/*
 * Assignment 3
 * FileIO.java
 * 
 * Author:Hanad Mohamed
 * Date: 03/01/2018
 * 
 */

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.nio.*;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
public class FileIO {

    private static ArrayList<String> collectWords(String fileName, int count) throws IOException, FileNotFoundException  {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int i = 0;
        ArrayList<String> arrL = new ArrayList<String>(i);
        ArrayList<String> arrL2 = new ArrayList<String>(i);
        String definition = "";
        //The following reads from our dictionary.txt file
        while((line = br.readLine()) != " " && line != null){
            String [] words = line.split(" ");
            definition = "";
            try 
                {arrL.add(words[0]);
                  for(i = 1; i < words.length; i++) {
                   definition = definition + words[i] + " ";
               
                  }
                  arrL2.add(definition);
            } catch(ArrayIndexOutOfBoundsException e) {
                NewException newException = new NewException(
                    e.getMessage(), e
                );
                throw newException;
        }  } 
        ArrayList<String> randomWords = new ArrayList<String>(99);
        ArrayList<String> randomDefinitions = new ArrayList<String>(99);
        //The following derives our 100 random words and places them in an arrayList
        for(i=0; i < count; i++) {
            int random = new Random().nextInt(arrL.size());
            randomWords.add(arrL.get(random));
            randomDefinitions.add(arrL2.get(random));
            
            
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("wordDefinitions.dat"));
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("wordDefinitions.txt"));
        //The following matches our words with definitions and writes them to wordDefinitions.dat and wordDefinitions.txt
        for(i=0; i<count; i++) {
            writer.write(randomWords.get(i) + randomDefinitions.get(i));
            writer.newLine();
            writer3.write(randomWords.get(i) + randomDefinitions.get(i));
            writer3.newLine();
        }
        writer.close();
        writer3.close();
        //The following composes our list of 100 random words from dictionary.txt
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("wordlist.txt"));
        for (String text : randomWords) {
            writer2.write(text);
            writer2.newLine();
        }
        writer2.close();
        br.close();
        
        fr.close();
        FileReader fread = new FileReader("wordDefinitions.dat");
        BufferedReader bread = new BufferedReader(fread);
        
        ArrayList<String> datWords = new ArrayList<String>(i);
        ArrayList<String> datDefinitions = new ArrayList<String>(i);
        while((line = bread.readLine()) != null) {
        String[] texts = line.split(" ");
            definition = "";
            try 
            {datWords.add(words[0]);
                  for(i = 1; i < count; i++) {
                   definition = definition + words[i] + " ";
               
                  }
                  datDefinitions.add(definition);
            } catch(ArrayIndexOutOfBoundsException e) {
                //e.printStackTrace();
            }
            
            
        }
        
        //The following uses the words in wordlist.txt and finds the definitins from wordDefiniton.dat
        BufferedWriter writer4 = new BufferedWriter(new FileWriter("wordDefinitions2.txt"));
        for (i=0; i<count; i++) {
            try {
                writer4.write(randomWords.get(i) + datDefinitions.get(i));
                writer4.newLine();}
            catch(IndexOutOfBoundsException e) {
            }
        }
        writer4.close();
        bread.close();
        fread.close();
        return arrL2;
       
        
    }
}
    public static void main (String[] args) throws IOException{

        try {
            collectWords("dictionary.txt", 100);
            
        } catch(NewException e) {
            System.out.println("File Not Found");
        } finally {
            System.out.println("Finally block was successfully executed"); 
        }
        //The following determines if our two wordDefinitions files are equal
        RandomAccessFile raf = new RandomAccessFile("wordDefinitions.txt", "r");
        RandomAccessFile raf2 = new RandomAccessFile("wordDefinitions2.txt", "r");
        byte[] arr = new byte[(int) raf.length()];
        byte[] arr2 = new byte[(int) raf2.length()];
        raf.readFully(arr);
        raf2.readFully(arr2);
        String s = new String(arr);
        String s2 = new String(arr2);
        Boolean areFilesEqual = s.equalsIgnoreCase(s2);
        System.out.println("Are the files equal: " + areFilesEqual);
    }

}