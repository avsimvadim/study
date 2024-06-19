package tricky_tasks;

public class FlattenNDimentionalArray {
    public static void main(String[] args) {
        // Example N-dimensional array
        Object[] nDimArray = new Object[]{
                1,
                new Object[]{2, 3, new Object[]{4, 5}},
                new Object[]{6, 7, new Object[]{8, new Object[]{9, 10}}}
        };

        int totalElements = countElements(nDimArray);
        Object[] flatArray = new Object[totalElements];
        flatten(nDimArray, flatArray, new int[]{0});
    }

    // recursive function to flatten N-dimensional array
    private static void flatten(Object[] inputArray, Object[] flatArray, int[] index) {
        for (Object element : inputArray) {
            if (element instanceof Object[]) {
                flatten((Object[]) element, flatArray, index);
            } else {
                flatArray[index[0]++] = element;
            }
        }
    }

    //recursive way to found the number of elements
    private static int countElements(Object[] inputArray) {
        int count = 0;
        for (Object element : inputArray) {
            if (element instanceof Object[]) {
                count += countElements((Object[]) element);
            } else {
                count++;
            }
        }
        return count;
    }
}
