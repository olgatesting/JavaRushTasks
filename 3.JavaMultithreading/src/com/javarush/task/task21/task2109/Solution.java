package com.javarush.task.task21.task2109;

/*
https://howtodoinjava.com/core-java/cloning/a-guide-to-object-cloning-in-java/
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {

           return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

     /*   protected Object clone() throws CloneNotSupportedException {

        } */

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable{

        @Override
        protected C clone() throws CloneNotSupportedException {
            C c = new C(this.getI(), this.getJ(), this.getName());
            return c;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        public C(int i, int j, String name) {

            super(i, j, name);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

       /* B b = new B(1, 2,"jhb");
        B b1 = (B) b.clone();
        System.out.print(b1.getName()); */
C c =new C(1,2,"bhjb");
C cl = (C)c.clone();
System.out.println(cl.getName());
        System.out.println(cl!=c);
        System.out.println(cl.equals(c));
        System.out.println(c.getClass()==cl.getClass());
    }
}
