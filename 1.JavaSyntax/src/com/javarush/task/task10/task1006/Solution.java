package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
10. Начальное значение переменных при инициализации менять нельзя. Можно добавлять только операторы приведения типа.
11. Программа должна выводить текст "result: 1000.0".
*/

public class Solution {
    public static void main(String[] args) {
        short b =  45; //45
        char c =  'c'; //c
        short s = (short) 1005.22; //1005
        int i =  150000; //32 767 && 18 928
        float f =  4.10f; //4
        double d =  1.256d; //1
        double result = (f * b) + (i / c) -  (d * s) + 562.78d;
       System.out.println("result: " + result);

    }
}