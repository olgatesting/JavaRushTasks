package com.javarush.task.task19.task1928;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
Исправить ошибку. Классы и интерфейсы
*/

public class Solution {
    {
        System.out.println("it's Solution class");
    }

    public static void main(String... args) throws IOException {
        String file1 ="C:\\Users\\User\\Desktop\\DreamJob\\Java\\file1.txt";
        String file2= "C:\\Users\\User\\Desktop\\DreamJob\\Java\\file2.txt";
        try (
                FileOutputStream outputStream = new FileOutputStream(file1);
                InputStream is = new FileInputStream(file2);
                //Solution.class.getClassLoader().getResourceAsStream(file2);
        ) {

            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "a";
            switch (s) {
                case "a": {
                    result = new Solution().new A();
                    break;
                }
                case "b": {
                    result = new Solution().new B();
                    break;
                }
                case "c": {
                    result = new Solution().new C();
                    break;
                }
            }

            if (result instanceof C) {
                C p = (C)result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("it's A class");
        }
    }

    class B implements Example {
        {
            System.out.println("it's B class");
        }
    }

    class C extends A {
        {
            System.out.println("it's C class");
        }
    }
}
