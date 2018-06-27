package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.03.2018.
 */
public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }
    public  void move() {
        for (int i =0; i< horses.size(); i++) {
            horses.get(i).move();
        }
    }
    public  void run() throws InterruptedException {
        for (int i=0; i<100; ) {
            move();
            print();
            Thread.sleep(200);
            i++;
        }
    }
    public  void print() {
        for (int i =0; i< horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i =0; i< 10; ) {
           System.out.println();
           i++;
        }
    }

    public Horse getWinner() {
        double max = 0.0;
        Horse winner = new Horse(null, 0.0,0.0);
        for (int i=0; i<this.horses.size(); i++)
        {
            if (horses.get(i).getDistance()>max) {
                max =horses.get(i).getDistance();
                winner = horses.get(i);
            }
        }

        return winner;
    }
    public void printWinner() {
        System.out.println("Winner is "+this.getWinner().getName() +"!");
    }
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public static void main(String[] args) {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("Jana", 3.0, 0.0));
        list.add(new Horse("Lena", 3.0, 0.0));
        list.add(new Horse("Vena", 3.0, 0.0));
        Hippodrome hippodrome1 = new Hippodrome(list);
        game = hippodrome1;
        try {
            game.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        game.printWinner();
    }
    

}
