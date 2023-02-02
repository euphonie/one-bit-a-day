package dynamicProgramming;

class FindLargestContiguousSubArraySum {
  
  // kadane's algorithm
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    
    int start = 0;
    int end = 0;
    
    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];
    for (int i = 1; i < n; i++) {
      // if current is larger than previous sum
      // choose to initiate a new subarray maximum
      if (nums[i] > maxEndingHere + nums[i]) {
        start = i;
        maxEndingHere = nums[i];
      } else 
        maxEndingHere = maxEndingHere + nums[i];
      
      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
        end = i;
      }
    }
    return maxSoFar;
  }

  public int maxSubArrayWindow(int[] nums) {
    int n = nums.length;

    int maxSoFar = nums[0];
    int[] window = new int[n];
    window[0] = nums[0];
    for (int i = 1; i < n; i++) {
      // if current is larger than previous sum
      // choose to initiate a new subarray maximum
      boolean currentLargerThanPrevious =
          (nums[i] > window[i-1] + nums[i]);
      window[i] = currentLargerThanPrevious ?
          nums[i] : 
          window[i-1] + nums[i];

      if (maxSoFar < window[i]) {
        maxSoFar = window[i];
      }
    }
    return maxSoFar;
  }
}
