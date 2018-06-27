package com.javarush.task.task19.task1913;
import java.io.*;
/*
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        char[] result = outputStream.toString().toCharArray();
        for (int i=0; i<result.length; i++) {
            if (Character.isDigit(result[i])) {
                System.out.print(result[i]);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
