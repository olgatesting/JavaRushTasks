package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream is = new FileInputStream(new File(args[0]));
        FileOutputStream os = new FileOutputStream(new File(args[1]));

        Charset UTF8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[1000];
        while (is.available()>0) {
            is.read(buffer);
            String s = new String(buffer, windows1251);
            buffer = s.getBytes(UTF8);
            os.write(buffer);
        }
      is.close();
      os.close();
    }
}
