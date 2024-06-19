package tricky_tasks;

public class Bills {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5};

        int smallestUnreachable = 1;

        for (int bill : arr) {
            if (bill > smallestUnreachable) {
                break;
            }
            smallestUnreachable += bill;
        }

        System.out.println(smallestUnreachable);
    }
}
