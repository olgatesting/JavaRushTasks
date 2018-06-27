package com.javarush.task.task20.task2016;

import java.io.*;

/*
Минимум изменений
*/
public class Solution {
    public static class A implements Serializable{
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public static class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception{
        A a = new Solution.A("jkn");
        B b = new Solution.B("fv");
        C c = new Solution.C("cfevc");
        FileOutputStream out = new FileOutputStream("C:\\Users\\User\\Desktop\\DreamJob\\Java\\file1.txt");
        FileInputStream in = new FileInputStream("C:\\Users\\User\\Desktop\\DreamJob\\Java\\file1.txt");
        ObjectOutputStream objOut= new ObjectOutputStream(out);
        ObjectInputStream objIn = new ObjectInputStream(in);
        objOut.writeObject(a);
        b = (Solution.B) objIn.readObject();
        c = (Solution.C) objIn.readObject();

        objOut.writeObject(c);

    }
}
