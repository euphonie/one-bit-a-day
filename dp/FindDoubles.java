package dp;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import static org.junit.Assert.assertEquals;

/**
 * Find doubles that appear only once.
 * Then if 2 and 4 appear once, return them as part of the result.
 * if 4 appears once but 8 appears twice, ignore the number.
 * Solution: time  O(n)
 *           space O(1)
 */
public class FindDoubles {

  public static Integer[] findDoubles(List<Integer> numbers) {
    int[] memo = new int[10001];
    // add time O(log n), contains O(log n)
    SortedSet<Integer> result =
        new TreeSet<Integer>();

    for (int number : numbers) {
      if (number % 2 == 0) {
        memo[number / 2] += 1;
      }
    }

    for (int number: numbers) {
      if (memo[number] == 1){
        result.add(number);
      }
    }
    return result.toArray(new Integer[0]);
  }


  public static void main(String[] args) {
    List<Integer> testCaseOne = Arrays.asList(1,2,3,4,5,6,7,8,0,8);
    List<Integer> testCaseTwo = Arrays.asList(7,17,11,1,23);
    List<Integer> testCaseThree = Arrays.asList(1,1,2);

    StringBuilder sb = new StringBuilder();
    for (int number : findDoubles(testCaseOne)){
      sb.append(number + " ");
    }

    assertEquals("0 1 2 3 ", sb.toString());
  }
}
