package hashtable;

import java.util.HashMap;
import java.util.Map;

class FindDuplicates {
  public boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int n = nums[i];
      int count = counts.getOrDefault(n, 0);
      if (count == 1) {
        return true;
      }
      counts.put(n, ++count);

    }
    return false;
  }
}