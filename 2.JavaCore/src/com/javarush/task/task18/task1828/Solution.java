package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ArrayList<String> fileArray = new ArrayList<String>();
        BufferedReader in;
        BufferedWriter out;
        String lineOfData, price,quantity, idS, productName = null;

        if ((args[0].equals("-u"))||(args[0].equals("-d"))) {
            in = new BufferedReader(new FileReader(fileName));
            out = new BufferedWriter(new FileWriter(fileName));
            idS = formatString(args[1],8);
            while ((lineOfData = in.readLine()) != null) {
                fileArray.add(lineOfData);
            }
            in.close();

            if (args[0].equals("-u"))  {

                quantity = args[args.length-1];
                price = args[args.length-2];
                for (int j=2; j <args.length-2; j++ ) {
                    productName = productName.concat(args[j]);
                }

                productName = formatString(productName,30);
                price = formatString(price,8);
                quantity = formatString(quantity,4);

                lineOfData = idS.concat(productName.concat(price.concat(quantity)));

                for (int i=0; i<fileArray.size();) {
                    if (!(((fileArray.get(i)).substring(0,7)).equals(idS))) {
                        i++;
                    } else {
                        fileArray.set(i,lineOfData);
                        break;
                    }
                }
                for (String s: fileArray) {
                    out.write(s);
                }
                out.close();
            }
            if (args[0].equals("-d")) {

                for (int i=0; i<fileArray.size();) {
                    if (!(((fileArray.get(i)).substring(0,7)).equals(idS))) {
                        i++;
                    } else {
                        fileArray.remove(i);
                        break;
                    }
                }
                for (String s: fileArray) {
                    out.write(s);
                }

                out.close();
            }
        }

    }
    public static String formatString(String draft, int length) {
        char[] neededArray = new char[length];
        Arrays.fill(neededArray, (char)32);
        char[] real = draft.toCharArray();
        int count = (neededArray.length < real.length) ? neededArray.length : real.length;
        for (int i = 0; i < count; i++) {
            neededArray[i] = real[i];
        }
        String q = String.valueOf(neededArray);
        return q;
    }
}


