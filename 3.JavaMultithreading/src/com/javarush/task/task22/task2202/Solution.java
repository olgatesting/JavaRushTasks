package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - "));
    }

    public static String getPartOfString(String string) {
        String res =null;
       try {
           String[] arr = string.split(" ");
        res = String.format("%s %s %s %s", arr[1], arr[2], arr[3], arr[4]);
       } catch (Exception e) {
           throw new TooShortStringException();
       }
       return res;
    }

    public static class TooShortStringException extends  RuntimeException{
    }
}
