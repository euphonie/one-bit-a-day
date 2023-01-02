package factorization;

import java.util.Arrays;

public class BrainGame
{
    public static int divisor(int n) {
        for (int i = 2; i<= Math.sqrt(n); i++) {
            if (n % i == 0) { return i; }
        }
        return 1;
    }
    
    public static boolean brainGame(int[] nums)
    {
        boolean player = true;
        while(true) {
            boolean madeMove = false;
            for(int i =0; i< nums.length; i++) {
                int divisor = BrainGame.divisor(nums[i]);
                if (divisor != 1) {
                    nums[i] = divisor;
                    madeMove = true;
                    System.out.println(Arrays.toString(nums));
                    System.out.println(player);
                    break;
                }
            }
            if (!madeMove){
                return !player;
            } else {
                player = !player;
            }
        }
        
    }

    public static void main(String args[]) {
        int[] nums = {7,13,11,14,7,11,14,12,2};
        System.out.println(BrainGame.brainGame(nums));

        int[] nums2 = {6,13,4,14,3,3,14};
        System.out.println(BrainGame.brainGame(nums2));

        int[] nums3 = {13,5,3,9,7,12,1};
        System.out.println(BrainGame.brainGame(nums3));

        //int[] nums = {5,7,3};
        //System.out.println(BrainGame.brainGame(nums));

        //int[] nums = {14};
        //System.out.println(BrainGame.brainGame(nums));
    }
}