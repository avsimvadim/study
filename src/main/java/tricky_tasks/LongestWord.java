package tricky_tasks;

public class LongestWord {
    public static void main(String[] args) {
        String s = "hello@3 link dog messy4 asteroid";
        String words[] = s.split(" ");
        String longest = "";
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            char[] ch = words[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (!Character.isLetter(ch[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag == true && words[i].length() > longest.length())
                longest = words[i];
        }
        System.out.println(longest);
    }
}
