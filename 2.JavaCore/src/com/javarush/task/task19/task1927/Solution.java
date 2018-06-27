package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в массив строк
        String [] arr = outputStream.toString().split("\\n");

        //Возвращаем все как было
        System.setOut(consoleStream);
       for (int i=0; i< arr.length; i++) {
           if (i != 0 && i % 2 == 0) {
               System.out.println("JavaRush - курсы Java онлайн");
               System.out.println(arr[i]);
           } else {System.out.println(arr[i]);}
       }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
