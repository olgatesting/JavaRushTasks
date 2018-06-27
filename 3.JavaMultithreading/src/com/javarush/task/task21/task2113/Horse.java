package com.javarush.task.task21.task2113;

/**
 * Created by User on 12.03.2018.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {

        return name;
    }

    public void move() {
        distance += speed*Math.random();
    }

    public void print() {
        for (int i=0; i<Math.floor(this.distance); ) {
            System.out.print('.');
            i++;
        }
        System.out.println(this.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
