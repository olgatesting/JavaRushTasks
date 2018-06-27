package com.javarush.task.task19.task1905;

import javax.swing.text.html.parser.Parser;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/*
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put ("UA", "Ukraine");
        countries.put ("RU", "Russia");
        countries.put ("CA", "Canada");

    }
    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
        }

        @Override
        public String getCountryCode() {
            String res = null;
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                String key = pair.getKey();                      //ключ
                String value = pair.getValue();                  //значение
                if (value.equals(customer.getCountryName())) {
                    res = key;
                }
            }
            return res;
        }


        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] stAr = contact.getName().split(", ");
            return stAr[1];
        }

        @Override
        public String getContactLastName() {
            String[] stAr = contact.getName().split(", ");
            return stAr[0];
        }

        @Override
        public String getDialString() {
            String phone = contact.getPhoneNumber();

            return "callto://" + String.format("%s%s%s%s%s", phone.substring(0,3), phone.substring(4,7), phone.substring(8,11), phone.substring(12,14),
                    phone.substring(15,17));
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}