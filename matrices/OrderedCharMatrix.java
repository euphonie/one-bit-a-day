package matrices;

import java.util.Arrays;
import java.util.List;

public class OrderedCharMatrix {

    public static String checkOrdered(int[][] matrix){
        int n = matrix[0].length;
        int m = matrix.length;
        
        for (int i = 0; i< n; i++) {
            for (int j = 0; j< m-1; j++){
                if (matrix[j][i] > matrix[j+1][i]){
                    return "NO";
                }
            }
        }
        return "YES";
    }

     /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        
        int[][] ascii = new int[grid.size()][grid.get(0).length()];

        int i = 0;
        for (String letters : grid) {
            int[] asciiValues = letters.chars().toArray();
            Arrays.sort(asciiValues);
            ascii[i++] = asciiValues;
        }

        System.out.println(Arrays.deepToString(ascii));

        return OrderedCharMatrix.checkOrdered(ascii);
    }

    public static void main(String args[]) {
        /*List<String> grid = Arrays.asList(
            "ebacd", "fghij", "olmkn", "trpqs", "xywuv"
        );*/
        List<String> grid = Arrays.asList("mpxz", "abcd", "wlmf");
        System.out.println(OrderedCharMatrix.gridChallenge(grid));
    }
    
}
