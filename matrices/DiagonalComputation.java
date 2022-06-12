package matrices;

public class DiagonalComputation {

    /**
     * this works for a square arr
     * @param arr
     */
    public static int getDifferenceOfDiagonalSums(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int sum = 0;

        int l = 0;
        int r = m -1;
        for(int i = 0; i < n; i ++){
            sum += (arr[i][l] - arr[i][r]);
            l++;
            r--;
        }

        return Math.abs(sum);
    }


    public static void main(String args[]) {

        int[][] counts = { 
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 } 
        };

        System.out.println(DiagonalComputation.getDifferenceOfDiagonalSums(counts));
    }
    
}
