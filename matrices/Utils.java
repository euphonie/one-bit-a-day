package matrices;
import java.util.List;

public class Utils {

    public static int[][] convertFrom2dList(List<List<Integer>> twodlist){
        int[][] matrix = new int[twodlist.size()][twodlist.size()];
        
        int i = 0;
        for (List<Integer> nestedList : twodlist) {
            matrix[i++] = nestedList.stream().mapToInt(Integer::intValue).toArray();
        }
        return matrix;
    }
    
}
