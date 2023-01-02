package arrays;

import java.util.Arrays;

public class ArrayRotation {

  public static void SplitAndAdd(int[] A, int length, int rotation) {
    int[] tmp = new int[length+rotation];
    System.arraycopy(A, 0, tmp, 0, length);
    System.arraycopy(A, 0, tmp, length, rotation);
    for(int i = rotation; i < rotation + length; i++) {
      A[i-rotation]=tmp[i];
    }
  }

  public static void main(String[] args) {
    int[] arr = {12, 10, 5, 6, 52, 36};
    int n = arr.length;
    int position = 5;

    SplitAndAdd(arr, n, position);

    System.out.println(Arrays.toString(arr));
  }
}
