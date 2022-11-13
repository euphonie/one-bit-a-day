package searching;

/**
 * LeetCode, https://leetcode.com/problems/binary-search/
 * 
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int pointer = nums.length/2;
        int l = 0;
        int r = nums.length -1;
        while(r - l > -1) {
            System.out.println(l + " " + r + " " + pointer );
            if (nums[pointer] == target) { return pointer; }
            if (r == l) { return -1; }
            else if (nums[pointer] > target) { 
                r = pointer;
            } else if (nums[pointer] < target) {
                l = pointer + 1;
            }
            pointer = (l + r)/2;
        }
        return -1;
    }

    public static int binarysearch(int arr[], int n, int k) {
        int l = 0;
        int r = n;
        
        int middle = n/2;
        while ( r - l > 0)  {
            if (arr[middle] == k) {
                return middle;
            }
            else if (arr[middle] > k){
                r = middle;
            } else {
                l = middle+1;
            }
            middle = (r+l)/2;
        }
        return -1;
    }

    public static void main(String args[]) {
        int target = 5;
        int[] nums = {-1,0,3,5,9,12};
        //int target = 5;
        //int[] nums = {5};
        //int target = 5;
        //int[] nums = {-1, 0, 5};
        //System.out.println(BinarySearch.search(nums, target));
        System.out.println(BinarySearch.binarysearch(nums, nums.length, target));
    }
}
