package tricky_tasks;

public class PalindromesString {
    public static void main(String[] args) {
        String s = "abckcba";
        boolean res = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                res = false;
                break;
            }
        }
        System.out.println(res);
    }
}
