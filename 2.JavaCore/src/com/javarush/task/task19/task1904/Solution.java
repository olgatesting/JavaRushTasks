package com.javarush.task.task19.task1904;

import com.sun.java_cup.internal.runtime.Symbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {
static final File myFile = new File ("./file.txt");

    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner{
      private Scanner fileScanner;

      PersonScannerAdapter ( Scanner fileScanner) throws FileNotFoundException {
          this.fileScanner = fileScanner;
      }
        //Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
        @Override
        public Person read() throws IOException, ParseException {
          fileScanner = new Scanner(myFile);
          Person person = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            if (fileScanner.hasNext()) {
                String s = fileScanner.nextLine();
                String[] data = s.split(" ");
                String firstName = data[1];
                String middleName = data[2];
                String lastName = data[0];

                Calendar cal = new GregorianCalendar(Integer.valueOf(data[5]), Integer.valueOf(data[4])-1, Integer.valueOf(data[3]));
                person = new Person(firstName, middleName,lastName,cal.getTime());
            }
            return person;
        }
        //Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
        @Override
        public void close() throws IOException {
        fileScanner.close();
        }
    }

}
