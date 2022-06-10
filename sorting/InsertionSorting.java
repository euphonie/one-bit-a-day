package sorting;

import java.util.Arrays;

/**
 * Best used in: 
 * - small numbers of elements
 * - few elements left to be sorted
 * 
 * Best O(n) Avg & Worst O(n**2)
 */
public class InsertionSorting {
    
    public static void sort(int[] array) {
        int size = array.length;

        // iterate steps from 1 to size
        for(int step = 1; step < size; step++) {
            int key = array[step];
            int j = step -1;

            // while going backwards and swapping values
            // there's still values and are still greater than key
            // continue
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // compensate last --j and assign key
            array[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        int[] data = {9,5 ,1,4,3};
        InsertionSorting.sort(data);

        System.out.println(
            String.format("Sorted ascending %s", Arrays.toString(data))
        );
    }

}
