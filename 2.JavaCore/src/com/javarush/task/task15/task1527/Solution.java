package com.javarush.task.task15.task1527;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] array1 = url.split("\\?");

        String[] array2 = array1[1].split("&");
        for (String s: array2) {
          String [] array3 = s.split("=");
          System.out.print(array3[0]+" ");
        }
        System.out.println();
        for (String s: array2) {
            String [] array3 = s.split("=");
           if (array3[0].equals("obj")){
               try {alert(Double.parseDouble(array3[1]));
               } catch (Exception e) {
                   alert (array3[1]);
               }
           }
        }
        }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
