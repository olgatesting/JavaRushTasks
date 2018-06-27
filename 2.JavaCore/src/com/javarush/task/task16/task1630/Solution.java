package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
       try {BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
       firstFileName = reader.readLine();
       secondFileName = reader.readLine();
       reader.close();
       } catch (IOException e) {

       }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private String filecontent ="";
        @Override
        public void setFileName(String fullFileName) {
        this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return filecontent;
        }

        public void run () {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
                // создаем reader типа буфера новый буфер для чтения
                // (из нового файла для чтения(с новым файлом (имя которого)))
                while (reader.ready()) // пока в reader'е есть что читать
                {
                    filecontent += reader.readLine() + " "; // дописываем строку к filecontent и + пробел
                }
                reader.close(); // закрываем этот ридер
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
