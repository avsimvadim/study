package tricky_tasks;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("this");
        dictionary.add("is");
        dictionary.add("a");
        dictionary.add("famous");
        dictionary.add("problem");
        String str="thisisafamousproblem";
        char[] arr = str.toCharArray();
        String res = "";
        String tmp = "";
        for (int i = 0; i < arr.length; i++) {
            tmp+=String.valueOf(arr[i]);
            if (dictionary.contains(tmp)){
                res += tmp + " ";
                tmp = "";
            }
        }
        System.out.println(res);
    }

}
