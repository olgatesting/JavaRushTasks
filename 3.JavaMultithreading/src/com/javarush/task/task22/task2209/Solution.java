package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
Составить цепочку слов
C:\Users\User\Desktop\DreamJob\Java\file1.txt
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader rcon = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileIn = new BufferedReader(new FileReader(rcon.readLine())))
        {
            StringBuilder sb = new StringBuilder();
            while (fileIn.ready()) {
                sb.append(fileIn.readLine());
            }
            String[] words = sb.toString().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;
        if (words.length==1 || words[0].equals("")) return result.append(words[0]);

        ArrayList list =new ArrayList();
        for (int i=0; i<words.length; i++) {
            list.add(words[i]);
        }
        String lastLetter, firstLetter, nextWord;

        lastLetter = list.get(0).toString().substring(list.get(0).toString().length()-1);
        result.append(list.get(0).toString()).append(' ');
        list.remove(list.get(0).toString());

            for (int j=0; j<list.size(); ) {
                nextWord = list.get(j).toString();
                firstLetter = nextWord.substring(0,1).toLowerCase();
                if (lastLetter.equals(firstLetter)) {
                    lastLetter = nextWord.substring(nextWord.length()-1);
                   result.append(nextWord).append(' ');
                   list.remove(nextWord);
                   j=0;
                } else {
                 j++;
                }
            }
            for (int i=0; i<list.size(); i++) {
                result.append(list.get(i).toString()).append(' ');
            }
        result.trimToSize();
          return result;
    }
}
