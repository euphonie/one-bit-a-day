package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;


// ref: https://leetcode.com/problems/unique-number-of-occurrences/description/
public class UniqueOccurrences {

  public static boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<> ();
    for (int i : arr) map.merge(i, 1, Integer::sum);
    Set<Integer> set = new HashSet<>(map.values());
    return map.size() == set.size();
  }

  public static boolean uniqueOccurrencesLong(int[] arr) {
    int[] counts = new int[2000];
    Map<Integer, Integer> seen = new HashMap<Integer, Integer>();

    for (int j = 0; j < arr.length; j++) {
      counts[arr[j] + 1000] += 1;
    }

    for (int i = 0; i < 2000; i ++) {
      if (counts[i] == 0){
        continue;
      }
      if (seen.containsKey(counts[i])){
        return false;
      }else {
        seen.put(counts[i], i);
      }
    }
    return true;
  }

  public static void main(String[] args){
    int[] arr = new int[]{1,2,2,1,1,3};
    int[] arr2 = new int[]{1, 2};
    System.out.println(uniqueOccurrences(arr));
    System.out.println(uniqueOccurrences(arr2));
    System.out.println(uniqueOccurrencesLong(arr));
    System.out.println(uniqueOccurrencesLong(arr2));
  }
}
