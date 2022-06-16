package arrays;

import java.util.Arrays;
import java.util.List;


/**
 * Inversion count problem
 */
public class MinimumBribes {
        
    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        boolean sorted = false;
        int temp;
        int bribeCount = 0;
        while (!sorted) {
           sorted = true;
           for (int i = 0; i< q.size()-1; i++){
               if (q.get(i) - (i+1) > 2){
                    System.out.println("Too chaotic");
                    return;
                } 
          
               if (q.get(i) > q.get(i+1)){
                   temp = q.get(i);
                   q.set(i, q.get(i+1));
                   q.set(i+1, temp);
                   sorted = false;
                   bribeCount++;
               }
           }
       }
       System.out.println(bribeCount);
    }

    public static void main(String args[]){
        //List<Integer> q = Arrays.asList(2,1,5,3,4);
        List<Integer> q = Arrays.asList(1,2,5,3,4,7,8,6);
        MinimumBribes.minimumBribes(q);
    }
}
