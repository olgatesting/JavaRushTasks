package com.javarush.task.task21.task2107;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Очень хорошая ссылка: https://howtodoinjava.com/core-java/cloning/a-guide-to-object-cloning-in-java/
Глубокое клонирование карты
*/
public class Solution  implements Cloneable{
    protected Map<String, User> users = new LinkedHashMap();
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        User u= new User(172, "Hubert");
        solution.users.put("Hubert", u);
        System.out.println(solution.users.containsValue(u));

        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone;
        try {
            clone = (Solution)solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Iterator<Map.Entry<String,User>> iterator = this.users.entrySet().iterator();
        Solution s =  new Solution();
        while (iterator.hasNext()){
            Map.Entry<String,User> entry = iterator.next();
            s.users.put(entry.getKey(),entry.getValue());
        }
        return s;
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User user= new User(0, null);
            user.age = this.age;
            user.name = this.name;
            return user;
        }
    }

}
