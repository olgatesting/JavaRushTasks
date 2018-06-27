package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
// 3. Нити не должны стартовать автоматически.
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        Thread1 t1 =  new Thread1();
        Thread2 t2  = new Thread2();;
        Thread3 t3  = new Thread3();;
        Thread4 t4  = new Thread4();;
        Thread5 t5  = new Thread5();;
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);
    }

//1.1. Нить 1 должна бесконечно выполняться;
    public static class Thread1 extends Thread {
        public void run(){
            while (true) {
            }
        }
    }
//1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
    public static class Thread2 extends Thread {
        public void run(){
            try {
                while (true) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }
    //1.3. Нить 3 должна каждые полсекунды выводить "Ура";
    public static class Thread3 extends Thread {
        public void run() {
            try {
                while (true)
            {
                System.out.println("Ура");
                Thread.sleep(500);
            }
            } catch (InterruptedException e){}

        }
    }
//1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
    public static class Thread4 extends Thread implements Message {
    boolean flag=true;
    @Override
    public void run() {
        try {
            while (flag) {
                if (Thread.currentThread().isAlive()){
                    showWarning();
                    this.join();
                }
            }
        }
        catch (Exception e){System.out.println(e);}
    }
    @Override
    public void showWarning() {
        try {flag=false;}
        catch (Exception e){System.out.println(e);}
    }
        }
//1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
    public static class Thread5 extends Thread {
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int sum = 0;
        boolean flag = true;
        try {
            while (flag) {
                s = reader.readLine();
                if (s.equals('N')) {
                    flag = false;
                }
                sum += Integer.parseInt(s);
            }
        } catch (Exception e) {
            System.out.println(sum);
        }
    }

}
    public static void main(String[] args) {
        for (int i=0; i<threads.size(); i++) {
            threads.get(i).start();
        }
    }
}
