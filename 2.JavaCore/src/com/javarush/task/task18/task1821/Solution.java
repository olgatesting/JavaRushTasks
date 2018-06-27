package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader(new File(args[0]));
        Map map = new TreeMap();

        int ch;
        int count =1;
        while ((ch = fr.read()) != -1) {
            if(map.containsKey((char)ch))
                map.put((char)ch, 1);

            else {
                map.put((char)ch, count);
            }
        }
        fr.close();
    }
}
