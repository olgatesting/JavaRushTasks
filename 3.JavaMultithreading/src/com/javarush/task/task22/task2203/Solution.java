package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null||(string.isEmpty())){throw new TooShortStringException();}
        String s=null;
        int firstIndex= string.indexOf("\t");
        int secondIndex = string.indexOf("\t", firstIndex+1);
        try{
         s= string.substring(firstIndex+1, secondIndex);
        } catch (Exception  e) {
             if (!(string.contains("\t"))||(string.indexOf("\t")==string.lastIndexOf("\t"))){
                throw new TooShortStringException();
            }
        }
          return s;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
/*indexOf(String str)
Returns the index within this string of the first occurrence of the specified substring.
int	indexOf(String str, int fromIndex)
Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.*/