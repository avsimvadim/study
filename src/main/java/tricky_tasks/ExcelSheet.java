package tricky_tasks;

public class ExcelSheet {
    public static void main(String[] args) {
        int res  = titleToNumber("ZY");
        System.out.println(res);
    }

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            sum+=((chars[i] - 64) * (Math.pow(26,chars.length - i - 1)));
        }
        return sum;
    }
}
