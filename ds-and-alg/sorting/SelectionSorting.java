package sorting;

import java.util.Arrays;

/**
 * Best used in:
 * - small list to be sorted
 * - cost of swapping does not matter
 * - checking of all the elements is compulsory
 * - cost of writing to a memory matter like in flash memory (number of writes/swaps)
 * 
 * Best, Worst & Avg O(n**2) 
 */
public class SelectionSorting {

    public static void sort(int array[]) {
        int size = array.length;

        // go through every array's position
        for (int step = 0; step < size -1 ; step++) {
            int min_idx = step;

            // find min()
            for (int i = step + 1; i < size; i ++) {
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }

            // swap to current position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    public static void main(String args[]) {
        int[] data = {20, 12, 10, 156, 4};
        SelectionSorting.sort(data);
        
        System.out.println(
            String.format("Sorted ascending %s", Arrays.toString(data))
        );
    }
}
