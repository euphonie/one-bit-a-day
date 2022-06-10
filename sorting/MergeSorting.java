package sorting;

import java.util.Arrays;

/**
 * Best used in:
 * - Inversion count problem
 * - external sorting
 * - e-commerce applications
 * 
 * Performs better mergeSortWithCopy = EnhancedMergeSort
 * 
 * Best, Avg & Worst O(n log n)
 * Space O(n)
 */
public class MergeSorting {
    
    public static void merge(int[] array, int p, int q, int r) {
        int upper = q - p + 1;
        int lower = r -q;

        int L[] = new int[upper];
        int M[] = new int[lower];

        // fill both subarrays
        for (int i = 0; i < upper; i++) 
            L[i] = array[p + i];
        for (int j = 0; j < lower; j++) 
            M[j] = array[q + 1 + j];
        
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < upper && j < lower) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while ( i < upper) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < lower) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    public static void mergeWithCopy(int[] array, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(array, l, m + 1);
        int[] right = Arrays.copyOfRange(array, m + 1, r + 1);

        int i = 0, j = 0, k = l;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]){
                array[k++] = left[i++];
            }
            else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length)
            array[k++] = left[i++];
        while (j < right.length)
            array[k++] = right[j++];
    }

    public static void sortWithCopy(int[] array, int l, int r) {
        System.out.println(l + " " + r + "\n");
        System.out.println(Arrays.toString(array));
        if (l < r) {
            int m = (l + r) /2;
            MergeSorting.sortWithCopy(array, l, m);
            MergeSorting.sortWithCopy(array, m +1, r);
            MergeSorting.mergeWithCopy(array, l, m, r);
        }
    }

    public static void sort(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            MergeSorting.sort(array, l, m);
            MergeSorting.sort(array, m + 1, r);
            MergeSorting.merge(array, l, m, r);
        }
    }

    public static void main(String args[]) {
        int data[] = { 0, 1, 2, 4, 6, 5, 3};

        MergeSorting.sortWithCopy(data, 0, data.length -1);
        System.out.println(
            String.format("Sorted ascending %s", Arrays.toString(data))
        );
    }
    
}
