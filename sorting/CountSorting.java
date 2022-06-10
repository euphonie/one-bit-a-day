package sorting;

import java.util.Arrays;

/**
 * Best used in: 
 * - smaller integers with multiple counts
 * - linear complexity is needed
 * - counting thresholds need to be counted
 * 
 * Best, Avg & Worst  O(n+k)
 * Space O(max)
 * Stable
 */
public class CountSorting {

    public static void sort(int[] arr) {
        int size = arr.length;
        int[] output = new int[size + 1];

        int max = arr[0];
        for(int i = 0; i < size; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        
        // initialization is trivial in java
        int[] count = new int[max + 1];

        // count each element
        for(int i = 0; i < size; i++) {
            count[arr[i]]++;
        }

        // cumulative count 
        for (int i = 1; i <= max; i++) {
            count[i] += count[i-1];
            // here counting thresholds can be counted
        }

        // find index of original array and place in output
        for (int i = size -1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // copy sorted into original
        for (int i = 0; i < size; i ++) {
            arr[i] = output[i];
        }
    }

    public static void main(String args[]) {
        int[] data = { 4,2,2,8,3,3,1};
        CountSorting.sort(data);
        System.out.println(
            String.format("Sorted ascending %s", Arrays.toString(data))
        );
    }
    
}
