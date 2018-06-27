package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
       transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FileOutputStream out = new FileOutputStream("C:\\Users\\User\\Desktop\\DreamJob\\Java\\file1.txt");
        ObjectOutputStream outO = new ObjectOutputStream(out);

        Person person = new Person("Ivan", "Ivanov", "Ukraine", Sex.MALE);
        System.out.println(person.firstName);
        System.out.println(person.lastName);
        System.out.println(person.fullName);
        System.out.println(person.greetingString);
        System.out.println(person.country);
        System.out.println(person.sex.toString());
        System.out.println(person.outputStream);
        System.out.println(person.logger);

        outO.writeObject(person);

        out.close();
        outO.close();

        FileInputStream in = new FileInputStream("C:\\Users\\User\\Desktop\\DreamJob\\Java\\file1.txt");
        ObjectInputStream inO = new ObjectInputStream(in);
        Person person2= (Person)inO.readObject();

        in.close();
        inO.close();

        System.out.println(person2.firstName);
        System.out.println(person2.lastName);
        System.out.println(person2.fullName);
        System.out.println(person2.greetingString);
        System.out.println(person2.country);
        System.out.println(person2.sex.toString());
        System.out.println(person2.outputStream);
        System.out.println(person2.logger);


    }
}
