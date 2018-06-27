package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("OLGA",null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            System.out.println(javaRush.users.get(0).getCountry().toString());
            System.out.println(javaRush.users.get(1).getCountry().toString());
            System.out.println(javaRush.users.get(2).getCountry().toString());
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
          if (  loadedObject.equals(javaRush)) {System.out.println("equal");
          } else {
              System.out.println("not equal");
          }
          System.out.println(loadedObject.users.get(0).getCountry().toString());
            System.out.println(loadedObject.users.get(1).getCountry().toString());
            System.out.println(loadedObject.users.get(2).getCountry().toString());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            if (users != null) {
                for (User user : users) {
                    pw.println(user.getFirstName());
                    pw.println(user.getLastName());
                    pw.println(user.getBirthDate().getTime());
                    pw.println(user.isMale());
                    pw.println(user.getCountry().getDisplayedName());
                }
            }
           pw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
               user.setBirthDate(new Date (Long.parseLong(reader.readLine())));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                String s= reader.readLine();
                if (s.equals("Ukraine")){user.setCountry(User.Country.UKRAINE);}
                if (s.equals("Russia")){user.setCountry(User.Country.RUSSIA);}
                if (s.equals("Other")){user.setCountry(User.Country.OTHER);}
                users.add(user);
            }
            reader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
