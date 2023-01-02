package arrays;

public class MissingNumberInArray {


    // Time complexity: O(n)
    // Space complexity: O(1)
    public static void main(String args[]) {
        
        int array[] = {1,2,3,4,5,6,7,8,10};
        int n = array.length;
        int arraySum = array[0];
        for(int i =1; i < array.length-1; i ++) {
            arraySum += array[i];
        }

        double size = (double)n;
        double summation = size * (size+1)/2;
        int result = (int)summation - (int)arraySum;
        System.out.println(result);
    }
    
}
