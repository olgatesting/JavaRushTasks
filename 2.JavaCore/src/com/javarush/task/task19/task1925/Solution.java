package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        FileWriter fw = new FileWriter(args[1]);
        BufferedReader br = new BufferedReader(fr);
       // BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder data2 = new StringBuilder();
        while (br.ready()) {
            String[] arr = br.readLine().split(" ");
            for (int i=0; i< arr.length; i++) {
                if (arr[i].length()>6) {
                    data2.append(arr[i]).append(",");
                }
            }
        }
        String line = data2.toString();
        line = line.substring(0, line.length()-1);
        fw.write(line);

        fr.close();
        fw.close();

    }
}
