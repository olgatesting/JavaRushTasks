package com.javarush.task.task19.task1908;
import java.io.*;
/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSource = reader.readLine();
        String fileTarget = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(fileSource));
        BufferedWriter out = new BufferedWriter(new FileWriter(fileTarget));

        while (in.ready()) {
            String[] data = in.readLine().split("\\s");
            for (int i=0; i<data.length; i++) {
              try {
                  Long l = Long.parseLong(data[i]);
                  out.write(data[i]+" ");
              } catch (Exception e) {
              }
            }
        }
        in.close();
        out.close();
    }
}
