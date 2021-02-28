package tricky_tasks;

import java.util.*;

// Given two strings str1 and str2. Return whether or not they are isomorphic.
// Two strings str1 and str2 are called isomorphic
// if there is a one to one mapping possible for every character of str1 to every character of str2. 
// And all occurrences of every character in ‘str1’ map to same character in ‘str2’

// str1 = "abab";
// str2 = "bdbd";
// true. a -> b, b -> d

// str3 = "abab";
// str4 = "cdce";
// false. a -> c, b -> d, b -/> e

// str5 = "ccab";
// str6 = "aaxa";
// false. c -> a, b -/> a

public class Isomorphic {

    public static void main(String[] args) {
        String str1 = "paper";
        String str2 = "title";
        System.out.println(isIsomorphic(str1,str2));
    }

    private static boolean isIsomorphic(String str1, String str2){

        char[] ch1arr = str1.toCharArray();
        char[] ch2arr = str2.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        for (int j = 0; j < 2; j++) {
            for(int i = 0; i < ch1arr.length; i++){
                if(map.containsKey(ch1arr[i])) {
                    if (ch2arr[i] != map.get(ch1arr[i]))
                        return false;
                }
                else
                    map.put(ch1arr[i],ch2arr[i]);
            }
            char[] tmp = ch1arr;
            ch1arr = ch2arr;
            ch2arr = tmp;
        }
        return true;
    }
}

