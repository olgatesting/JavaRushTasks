package com.javarush.task.task19.task1916;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        
        FileReader fr1 = new FileReader(reader.readLine());
        FileReader fr2 = new FileReader(reader.readLine());
        reader.close();
        BufferedReader br1= new BufferedReader(fr1);
        BufferedReader br2  = new BufferedReader(fr2);
       
        List<String> list1 = new ArrayList<String>();
        List<String>  list2= new ArrayList<String>();
        
        while (br1.ready()) {
            list1.add(br1.readLine());
        }
        
        while (br2.ready()) {
        list2.add(br2.readLine());
        }
        
       fr2.close();
       fr1.close();

        while (!list1.isEmpty() | !list2.isEmpty()) {
            if (list1.isEmpty()&list2.isEmpty()) {
                break;
            } else if (list2.isEmpty()&!(list1.isEmpty())) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }else if (list1.isEmpty()&&!(list2.isEmpty())) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            } else if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            } else if (list1.get(0).equals(list2.get(1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            } else {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            }
        }
      for (LineItem li: lines) {
          System.out.println(li.type + " " + li.line);
       }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

    }
}
