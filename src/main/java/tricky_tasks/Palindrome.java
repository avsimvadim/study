package tricky_tasks;

//read same in both sides

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        char[] arr = s.replaceAll("\\s", "")
                .replaceAll("[^A-Za-z0-9]", "")
                .toLowerCase()
                .toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j])
                return false;
        }
        return true;
    }
}
