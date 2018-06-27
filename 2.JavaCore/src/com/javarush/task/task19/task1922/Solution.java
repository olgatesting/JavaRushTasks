package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String data;
        int count = 0;
        while (br.ready()) {
            data = br.readLine();
            String arr[] = data.split(" ");
            for (int i=0; i< arr.length; i++) {
                for (int j = 0; j< words.size(); j++) {
                    if (arr[i].equals(words.get(j))) {
                        count++;
                    }
                }
            }
            if (count==2) {
                System.out.println(data);
            }
            count =0;
        }
        fr.close();
        br.close();
    }
}
