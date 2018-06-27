package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            StringBuilder sb = new StringBuilder(br.readLine());
            sb = sb.reverse();
            System.out.println(sb.toString());
        }
        fr.close();
        br.close();

    }
}
