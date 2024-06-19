package sandbox;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            map.put(haystack.substring(i, i + needle.length()), i);
        }

        if(map.containsKey(needle)){
            System.out.println(map.get(needle));
        } else {
            System.out.println(-1);
        }
    }
}
