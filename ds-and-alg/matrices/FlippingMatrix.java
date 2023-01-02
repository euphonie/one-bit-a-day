package matrices;

import java.util.List;

public class FlippingMatrix {
    public static int getMaxFromFourCoordinates(int[][] m) {
        int sum =0;
        int width = m[0].length;
        int height = m.length;
        
        for (int i = 0; i < width/2; i++ ) {
            for (int j = 0; j < height/2; j++) {
                int cx1 = i;
                int cx2 = width - i - 1;
                int cy1 = j;
                int cy2 = height - j -1;
                
                sum += Math.max(
                    Math.max(m[cx1][cy1], m[cx1][cy2]), 
                    Math.max(m[cx2][cy1], m[cx2][cy2])
                );
            }
        }
        
        return sum;
        
    }
    
     public static int[][] convertFrom2dList(List<List<Integer>> twodlist){
        int[][] matrix = new int[twodlist.size()][twodlist.size()];
        
        int i = 0;
        for (List<Integer> nestedList : twodlist) {
            matrix[i++] = nestedList.stream().mapToInt(Integer::intValue).toArray();
        }
        return matrix;
    }


    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int[][] m = FlippingMatrix.convertFrom2dList(matrix);
        return FlippingMatrix.getMaxFromFourCoordinates(m);
    }

    public static int flippingMatrixPrimitive(int[][] matrix) {
        return FlippingMatrix.getMaxFromFourCoordinates(matrix);
    }


    public static void main(String args[]) {
        int mat[][] = {
            {112, 42, 83, 119},
            {56, 125, 56, 49},
            {15, 78, 101, 43},
            {62, 98, 114, 108}
        };
        System.out.println(FlippingMatrix.flippingMatrixPrimitive(mat));
    }
}
