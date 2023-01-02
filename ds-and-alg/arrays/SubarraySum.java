package arrays;

import java.util.ArrayList;

public class SubarraySum {

    public static ArrayList<Integer> findSum(int[] arr, int sum) {
        ArrayList<Integer> items = new ArrayList<Integer>();
        int curr_sum_window = arr[0];
        int start = 0;
        
        for (int i =1; i <= arr.length; i++) {
            
            System.out.print(String.format("%s %s %s ", curr_sum_window, start, i));
            // if window exceeds sum, move start pointer and remove values that exceed
            while (curr_sum_window > sum && start <= i ){
                curr_sum_window -= arr[start];
                start++;
            }

            if (curr_sum_window == sum) {
                items.add(start + 1);
                items.add(i);
                // look first subarray matching
                break;
            }

            if (i < arr.length)
                curr_sum_window += arr[i];
            System.out.println(String.format("- %s %s %s ", curr_sum_window, start, i));
        }

        if (items.size() == 0) 
            items.add(-1);
        return items;
    }


    public static void main(String args[]) {

        int arr[] = {1,2,3,7,5};
        int expectedSum = 12;

        //int arr[] = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        //int expectedSum = 468;

        System.out.println(
           SubarraySum.findSum(arr, expectedSum).toString()
        );

    }
    
}
