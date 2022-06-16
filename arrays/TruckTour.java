package arrays;
import java.util.Arrays;
import java.util.List;

public class TruckTour {

    public static int[] convertFrom2dList(List<List<Integer>> twodlist){
        int[] matrix = new int[twodlist.size()];
        
        int i = 0;
        for (List<Integer> nestedList : twodlist) {
            matrix[i++] = nestedList.get(0) - nestedList.get(1);
        }
        return matrix;
    }

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int[] pumps = TruckTour.convertFrom2dList(petrolpumps);
        System.out.println(Arrays.toString(pumps));
        int i = 0;
        while (true) {
            while (pumps[i] <0) {
                i = (i+1) % pumps.length;
            }
            long temp =0;
            int j = i==0? pumps.length - 1 : i-1;
            while (temp >=0) {
                System.out.println(i + " " + j + " " + temp);
                if (i == j) {
                    return (i + 1) % pumps.length;
                }
                temp += pumps[i];
                i = (i+1) % pumps.length;
            }
        }
    }
    

    public static void main(String args[]) {
        List<List<Integer>> pumps = Arrays.asList(Arrays.asList(10,2), Arrays.asList(10,3), Arrays.asList(3,4));
        System.out.println(TruckTour.truckTour(pumps));
    }
    
}
