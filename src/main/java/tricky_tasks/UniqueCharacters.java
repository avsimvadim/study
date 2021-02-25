package tricky_tasks;

import java.util.*;

public class UniqueCharacters {
    public static void main(String[] args) {
        String str = "abc d  e fa k";
        System.out.println(isUnique(str));
    }

    public static boolean isUnique(String str) {
        if (str == null || str.isEmpty())
            return false;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch) && chars.add(ch) == false)
                return false;
        }
        return true;
    }
}
