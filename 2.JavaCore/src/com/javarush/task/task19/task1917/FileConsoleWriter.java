package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    FileWriter fileWriter;
    public static void main(String[] args) {

    }

    FileConsoleWriter (File file) {
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    FileConsoleWriter (File file, boolean append) {
        try {
            fileWriter = new FileWriter(file, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    FileConsoleWriter (FileDescriptor fd) {
            fileWriter = new FileWriter(fd);
    }

    FileConsoleWriter (String fileName) {
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    FileConsoleWriter (String fileName, boolean append) {
        try {
            fileWriter = new FileWriter(fileName, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i=off+1; i<=len; i++) {
            System.out.print(cbuf[i]);
        }
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);

    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }
    public void write(String str, int off, int len) throws IOException{
       fileWriter.write(str, off, len);
       char[] arr = str.toCharArray();
       for (int i=off+1; i<=len;i++) {
           System.out.print(arr[i]);
       }
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        String s= cbuf.toString();
        System.out.print(s);
    }
    public void close() throws IOException {
        fileWriter.close();
    }

}
