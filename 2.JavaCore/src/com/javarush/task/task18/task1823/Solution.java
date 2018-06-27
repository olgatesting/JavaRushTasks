package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово «exit«.
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String — это имя файла, параметр Integer — это искомый байт.
Закрыть потоки.
*/

public class Solution  {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       try {
           while (true) {
               String fileName = reader.readLine();
               if (fileName.equals("exit")) {
                   break;
               } else {
                   ReadThread readThread = new ReadThread(fileName);
                   readThread.start();
               }
           }
       } catch (IOException e) {System.out.println("Error1");}
        finally {
           try {
               reader.close();
           } catch (IOException e2) {System.out.println("Error2");}
       }
    }

    public static class ReadThread extends Thread{
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
         this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            BufferedReader is = null;
            int maxByteCount=0;
            int id=0;
            ArrayList<Integer> list= new ArrayList<Integer>();
            try {
                is =  new BufferedReader(new FileReader(fileName));
                while (is.ready()) {
                list.add(is.read());
                }
                for (int i=0; i<=list.size()-1; i++) {
                    int freq=Collections.frequency(list, list.get(i));
                    if ( freq> maxByteCount) {
                        maxByteCount = freq;
                        id=list.get(i);
                    }
                }
                resultMap.put(fileName,id);
                }
             catch (IOException e)  {System.out.println("Error3");}
            finally {
                try {
                    is.close();
                }  catch (IOException e2)  {System.out.println("Error4");}
            }
        }

    }
}
