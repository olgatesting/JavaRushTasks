package com.javarush.task.task20.task2018;

/**
 * Created by User on 01.03.2018.
 */

public class Calculator{
    int num = 100;
    public void calc(int num) {
        this.num = num * 10;
    }
    public void printNum(){
        System.out.println(num);
    }
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        obj.calc(2);
        obj.printNum();
    }
}



