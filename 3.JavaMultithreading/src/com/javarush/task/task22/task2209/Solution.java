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
            System.out.println(sb.toString());
            String[] words = sb.toString().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        if ( words ==null || words.toString().isEmpty()) return null;
        ArrayList list =null;
        for (int i=0; i<words.length; i++) {
            list.add(words[i]);
        }
        Collections.sort(list);

        StringBuilder builder = new StringBuilder();
        ArrayList<String> wordsInChain = new ArrayList<>();
        ArrayList<String> wordsNotInChain = new ArrayList<>();

        for (int i=0; i<list.size(); i++) {
            String word = list.get(i).toString();
            for (int k=0; k<list.size() ; k++) {
                String secWord = list.get(k).toString().toLowerCase();
                if (!(wordsInChain.contains(word))&& (word.charAt(word.length()-1)==secWord.charAt(0))) {
                    wordsInChain.add(word);
                    wordsInChain.add(secWord);
                    i++;
                } else {
                    if (!wordsNotInChain.contains(word))
                    {
                        wordsNotInChain.add(word);
                    }
                    i++;
                }
            }
        }

        for (int i=0; i<wordsInChain.size(); i++) {
            builder.append(wordsInChain.get(i)).append(' ');
        }

        for (int i=0; i<wordsNotInChain.size(); i++) {
            builder.append(wordsNotInChain.get(i)).append(' ');
        }
        builder.trimToSize();
          return builder;
    }
}
