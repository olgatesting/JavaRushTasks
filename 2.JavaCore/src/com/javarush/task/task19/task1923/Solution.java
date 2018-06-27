package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(args[1]);
        BufferedWriter bw = new BufferedWriter(fw);
        String data;
            while (br.ready()) {
          data = br.readLine();
          String[] arr  = data.split(" ");
          for (int i=0; i< arr.length; i++) {
                if (!arr[i].matches("^\\D*$")) {
                    bw.write(arr[i]+ " ");
              }
          }
        }
      //  fr.close();
      //  fw.close();

       br.close();
       bw.close();
    }
}
