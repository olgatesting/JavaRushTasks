package com.javarush.task.task01.task0140;

import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        int a;
        //напишите тут ваш код
        Scanner in = new Scanner(System.in);
        //System.out.println("Введите нужное число");
        a = in.nextInt();
        System.out.println(a*a);
    }
}