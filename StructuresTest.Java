/*
 * Final Project
 * StructuresTest.java
 * 
 * Author:Hanad Mohamed
 * Date: 05/03/2018
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
import java.util.Scanner;
public class StructuresTest{
    static BufferedWriter writer;
    static ArrayList<String> CorrectAnswers = new ArrayList<String> ();
    static ArrayList<String> IncorrectAnswers = new ArrayList<String> ();
    //The Following implements the concept of Exception Handling
    public static void main(String[] args) throws IOException, FileNotFoundException{
        FileReader fr = new FileReader("questionBank.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int i = 0;
        //The Following implements the concepts of Arrays and ArrayLists
        ArrayList<String> questions = new ArrayList<String>();
        ArrayList<String> answers = new ArrayList<String>();
        ArrayList<String> q1 = new ArrayList<String>();
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<String> q2 = new ArrayList<String>();
        ArrayList<String> a2 = new ArrayList<String>();
        ArrayList<String> q3 = new ArrayList<String>();
        ArrayList<String> a3 = new ArrayList<String>();
        ArrayList<String> q4 = new ArrayList<String>();
        ArrayList<String> a4 = new ArrayList<String>();
        ArrayList<String> q5 = new ArrayList<String>();
        ArrayList<String> a5 = new ArrayList<String>();
        ArrayList<String> q6 = new ArrayList<String>();
        ArrayList<String> a6 = new ArrayList<String>();
        ArrayList<String> q7 = new ArrayList<String>();
        ArrayList<String> a7 = new ArrayList<String>();
        ArrayList<String> q8 = new ArrayList<String>();
        ArrayList<String> a8 = new ArrayList<String>();
        ArrayList<String> q9 = new ArrayList<String>();
        ArrayList<String> a9 = new ArrayList<String>();
        ArrayList<String> q10 = new ArrayList<String>();
        ArrayList<String> a10 = new ArrayList<String>();
         while((line = br.readLine()) != " " && line != null){
            String[] eachLine = line.split("::");//This line implements the line.split method, which we learned about in the REGEX chapter
            questions.add(eachLine[0]);
            answers.add(eachLine[1]);
            
            }
         for(i=0; i<10;i++) {
            q1.add(questions.get(i));
            a1.add(answers.get(i));
            }
         
         for(i=10; i<20;i++) {
            q2.add(questions.get(i));
            a2.add(answers.get(i));
            }
         for(i=0; i<10;i++) {
            q1.add(questions.get(i));
            a1.add(answers.get(i));
            }
         for(i=20; i<30;i++) {
            q3.add(questions.get(i));
            a3.add(answers.get(i));
            }
         for(i=30; i<40;i++) {
            q4.add(questions.get(i));
            a4.add(answers.get(i));
            }
         for(i=40; i<50;i++) {
            q5.add(questions.get(i));
            a5.add(answers.get(i));
            }
         for(i=50; i<60;i++) {
            q6.add(questions.get(i));
            a6.add(answers.get(i));
            }
         for(i=60; i<70;i++) {
            q7.add(questions.get(i));
            a7.add(answers.get(i));
            }
         for(i=70; i<80;i++) {
            q8.add(questions.get(i));
            a8.add(answers.get(i));
            }
         for(i=80; i<90;i++) {
            q9.add(questions.get(i));
            a9.add(answers.get(i));
            }
         for(i=90; i<100;i++) {
            q10.add(questions.get(i));
            a10.add(answers.get(i));
            }
            
        System.out.println("Enter your name to begin the exam");
        Scanner so = new Scanner(System.in);
        String name = so.nextLine();
   BufferedWriter writer = new BufferedWriter(new FileWriter("userName_dateTimeStamp.txt"));

   printAnswer(q1,a1,0,1);
   printAnswer(q2,a2,0,2);
   printAnswer(q3,a3,0,3);
   printAnswer(q4,a4,0,4);
   printAnswer(q5,a5,0,5);
   printAnswer(q6,a6,0,6);
   printAnswer(q7,a7,0,7);
   printAnswer(q8,a8,0,8);
   printAnswer(q9,a9,0,9);
   printAnswer(q10,a10,0,10);
   System.out.println("You got the following answers correct: ");
   System.out.println(CorrectAnswers);
   System.out.println("You got the following answers incorrect");
   System.out.println(IncorrectAnswers);
   System.out.println("Total Correct: " + CorrectAnswers.size());
   
   writer.write("Exam Results");
   writer.newLine();
   writer.write("Student Name: " +name);
   writer.newLine();
   writer.write("You got the following questions correct: ");
   writer.newLine();
   for(String text:CorrectAnswers) {
    writer.write(text);
    writer.newLine();
    }
       writer.write("You got the following questions incorrect: ");
       writer.newLine();
    for(String text:IncorrectAnswers) {
    writer.write(text);
    writer.newLine();
    }
   writer.write("Total Correct Answers: " + CorrectAnswers.size());
   writer.newLine();
   writer.write("Total Incorrect Answers: " + IncorrectAnswers.size());
    writer.close();
   

    }
    //This line also implements exception handling
    public static void printAnswer(ArrayList<String> q, ArrayList<String> a, int r, int category) throws IOException, FileNotFoundException{
    int i = 1;
    while(i<4) {
        Random randomQuestion = new Random();
        int x = randomQuestion.nextInt(9);
        System.out.println(q.get(x));
        Scanner so = new Scanner(System.in);
        String word = so.nextLine();
        if(a.get(x).equalsIgnoreCase(word)) {
        System.out.println("Correct");
        String s =("Category: " + category + " Question: " + i);
        CorrectAnswers.add(s);
        r = r + 1;
        } else{
            System.out.println("Incorrect");
            
            System.out.println("CORRECT ANSWER: " + a.get(x));
            String s =("Category: " + category + " Question: " + i);
            IncorrectAnswers.add(s);
        }
        i=i+1;
    }
    System.out.println("Category Score: " + r);
    }



}
