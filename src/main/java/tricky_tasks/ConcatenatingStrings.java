package tricky_tasks;

//{X-----Y},{U-----K},{Y~~U} -> X-----Y~~U-----K
public class ConcatenatingStrings {
    public static void main(String[] args) {
        String[] arr = {"K+++P","R====X","X-----Y","U-----K","Y~~U"};
        System.out.println(simple(arr));
    }

    //O(n^2)
    public static String simple(String[] arr){
        String result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (result.charAt(0) == arr[j].charAt(arr[j].length() - 1))
                    result = arr[j] + result;
                if (arr[j].charAt(0) == result.charAt(result.length() - 1))
                    result = result + arr[j];
            }
        }
        return result;
    }
}
