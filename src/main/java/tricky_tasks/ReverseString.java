package tricky_tasks;

//only O(1) solution
//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
public class ReverseString {
    public static void main(String[] args) {
        char arr[] = {'h','e','l','l','o'};
        reverseString(arr);
        for (char ch:
             arr) {
            System.out.print(ch + " ");
        }
    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
