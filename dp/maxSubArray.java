package dp;


import java.util.Arrays;

// Java program for the above approach
class maxSubArray {

  static double INF = 1E9;

  // Function to find the maximum score
  // achieved by alternative minus-plus
  // of elements of a subsequence in
  // the given array
  public static int maxScore(int arr[], int N) {
    int[] dp1 = new int[N + 1];
    int[] dp2 = new int[N + 1];

    dp1[0] = (int) -INF;
    dp2[0] = 0;

    for (int i = 0; i < N; ++i) {
      dp1[i + 1] = Math.max(dp1[i], dp2[i] + arr[i]);
      dp2[i + 1] = Math.max(dp2[i], dp1[i] - arr[i]);
      System.out.println(Arrays.toString(dp1));
      System.out.println(Arrays.toString(dp2));
    }

    // Return the maximum
    return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
  }

  public static int maxProfit(int prices[]) {
    int N = prices.length;
    int[] min = new int[N + 1];
    int[] max = new int[N + 1];

    min[0] = Integer.MAX_VALUE;
    max[0] = 0;
    int profit = 0;
    for (int i = 0; i < N; i++) {
      min[i + 1] = Math.min(min[i], prices[i]);

      if (prices[i] < min[i]) {
        max[i + 1] = prices[i];
      } else {
        max[i + 1] = Math.max(max[i], prices[i]);
      }
      profit = Math.max(profit, max[i+1] - min[i+1]);
      System.out.println(Arrays.toString(min));
      System.out.println(Arrays.toString(max));
    }

    return profit;
  }

  public static int maxProfitFaster(int prices[]) {
    int N = prices.length;

    int min = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < N; i++) {
      if (prices[i] < min) {
        min = prices[i];
      }

      int max = prices[i] - min;
      if (profit < max){
        profit = max;
      }
    }

    return profit;
  }

  // Driver Code
  public static void main(String args[]) {
    int arr[] = {2, 3, 6, 5, 4, 7, 8};
    int arr2[] = {7, 1, 5, 3, 6, 4};
    //int N = arr2.length;

    int arr3[] =
        {20, 19, 18, 17, 16, 15, 14, 13, 12, 11,
            10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int N = arr3.length;

    System.out.println(maxProfitFaster(arr3));
  }
}