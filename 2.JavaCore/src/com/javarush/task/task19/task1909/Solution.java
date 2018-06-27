package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = reader.readLine();
        String targetFile = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter out = new BufferedWriter(new FileWriter(targetFile));

        while (in.ready()) {
            String data = in.readLine().replaceAll(".","!");
            out.write(data);
        }
        in.close();
        out.close();
    }
}
