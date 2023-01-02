package sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Best used in:
 * - complexity does not matter
 * - short and simple code is preferred
 * 
 * Best O(n) Worst & Avg O(n**2)
 */
class BubbleSorting {
    static void sort(int[] array, boolean isAscending) {
        int size = array.length;

        // Run n times for every value in array
        for (int i = 0; i< size -1; i++) {
            // swap all values that apply at this iteration
            for (int j = 0; j < size -1; j++) {

                if (BubbleSorting.compare(array[j], array[j+1], isAscending)) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
    }

    static int[] bubleSortList(List<Integer> list, boolean isAscending) {
        int[] numbers = list.stream().mapToInt(Integer::intValue).toArray();
        BubbleSorting.sort(numbers, isAscending);
        return numbers;
    }

    static boolean compare(int i, int j, boolean isAscending) {
        return isAscending ? i > j : i < j;
    }

    public static void main(String args[]) {
        int[] data =  {-2, 45, 0, 11, -9, 32};
        List<Integer> listedData = Arrays.asList(-2, 45, 0, 11, -9, 32);

        boolean useArray = false;
        if (useArray){
            BubbleSorting.sort(data, true);
        } else {
            data = BubbleSorting.bubleSortList(listedData, true);
        }

        System.out.println(
            String.format("Sorted ascending %s", Arrays.toString(data))
        );
        int middle = data[data.length/2];
        System.out.println(middle);
    }
}

