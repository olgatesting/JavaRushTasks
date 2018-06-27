package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {

        System.out.println(new Solution(4));
        FileOutputStream out = null;
        FileInputStream in = null;
        File file = new File ("C:\\Users\\User\\Desktop\\DreamJob\\Java\\file1.txt");
        try {
            out = new FileOutputStream("file");
            in = new FileInputStream("file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Solution savedObject = new Solution(5);
        Solution loadedObject = new Solution(10);
        ObjectOutputStream outputStream;
        ObjectInputStream inputStream;
        try {
            outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(savedObject);
            out.close();
            outputStream.close();
            inputStream = new ObjectInputStream(in);
            loadedObject = (Solution) inputStream.readObject();
            in.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(savedObject.toString().equals(loadedObject.toString()));

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
