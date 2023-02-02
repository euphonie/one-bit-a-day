package dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindLargestContiguousSubArraySumTest {

  @Test
  public void shouldReturnOnlyValue() {
    FindLargestContiguousSubArraySum subArrayMaximizer = new FindLargestContiguousSubArraySum();
    assertEquals(
        1,
        subArrayMaximizer.maxSubArray(new int[]{1})
    );
  }

  @Test
  public void shouldFindMaxSubArray() {
    FindLargestContiguousSubArraySum subArrayMaximizer = new FindLargestContiguousSubArraySum();
    assertEquals(
        6,
        subArrayMaximizer.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})
    );
  }
  
  @Test
  public void shouldFindMaxSubArrayWithWindow() {
    FindLargestContiguousSubArraySum subArrayMaximizer = new FindLargestContiguousSubArraySum();
    assertEquals(
        6,
        subArrayMaximizer.maxSubArrayWindow(new int[]{-2,1,-3,4,-1,2,1,-5,4})
    );
  }

  @Test
  public void shouldFindMaxCompleteArray() {
    FindLargestContiguousSubArraySum subArrayMaximizer = new FindLargestContiguousSubArraySum();
    assertEquals(
        23,
        subArrayMaximizer.maxSubArray(new int[]{5,4,-1,7,8})
    );
  }
  
  @Test
  public void shouldFindMaxCompleteArrayWithWindow() {
    FindLargestContiguousSubArraySum subArrayMaximizer = new FindLargestContiguousSubArraySum();
    assertEquals(
        23,
        subArrayMaximizer.maxSubArrayWindow(new int[]{5,4,-1,7,8})
    );
  }
}