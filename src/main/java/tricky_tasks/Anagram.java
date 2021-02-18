package tricky_tasks;

//anagram is a word or phrase formed by rearranging the letters of a different word
//O(n)
public class Anagram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";

        System.out.println(check(s1, s2));
    }

    private static int CHARACTER_RANGE= 256;

    private static boolean check(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

}
