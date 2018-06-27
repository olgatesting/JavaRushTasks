package com.javarush.task.task19.task1907;
import java.io.*;
/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader  in = new BufferedReader  (new FileReader(fileName));
        int count=0;
        while (in.ready()) {
            String dataLine = in.readLine();
            String[] array = dataLine.split("\\W");
            for (int i=0; i< array.length;i++) {
                if (array[i].equals("world")) {
                    count++;
                }
            }
        }
        System.out.println(count);
        in.close();
    }
}
