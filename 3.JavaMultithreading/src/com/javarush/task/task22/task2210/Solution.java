package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;
//   {"level22", "lesson13", "task01"}

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        getTokens("jknjknkj*nklnlkn*kjhjhkjhkjl", "*");

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);

        int count = tokenizer.countTokens();
        String[] result = new String[count];

        for (int i=0; i<count; i++)
        {
            result[i] = tokenizer.nextToken();
        }
        return result;
    }
}
