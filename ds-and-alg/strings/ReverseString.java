package strings;

import java.util.Scanner;

interface ReverseStrategy {
  String reverse(String s);
}

class StringReverser {
  private static ReverseStrategy reverser;

  public StringReverser(ReverseStrategy reverser){
    this.reverser = reverser;
  }
  public static String reverse(String original) {
    return reverser.reverse(original);
  }

  // brute force solver
  static class BeteReverseStrategy implements ReverseStrategy {
    @Override public String reverse(String s) {
      long startTime = System.nanoTime();

      char[] chars = s.toCharArray();
      int n = chars.length;
      for (int i = 0; i < n /2; i ++) {
        char c = chars[i];
        chars[i] = chars[n-i-1];
        chars[n-i-1] = c;
      }

      String reversed = chars.toString();

      long elapsedTime = System.nanoTime() - startTime;
      System.out.printf("%d\n", elapsedTime);
      return reversed;
    }
  }

  static class SBReverseStrategy implements ReverseStrategy {
    @Override public String reverse(String s) {
      long startTime = System.nanoTime();
      final StringBuilder sb = new StringBuilder(s);
      long elapsedTime = System.nanoTime() - startTime;
      System.out.printf("%d\n", elapsedTime);
      return sb.reverse().toString();
    }
  }
}

public class ReverseString {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    StringReverser.BeteReverseStrategy beteStrategy = new StringReverser.BeteReverseStrategy();
    StringReverser simpleReverser = new StringReverser(beteStrategy);

    StringReverser.SBReverseStrategy sbStrategy = new StringReverser.SBReverseStrategy();
    StringReverser sbReverser = new StringReverser(sbStrategy);

    System.out.printf("Reversed (Simple): %s\n", simpleReverser.reverse(A));
    System.out.printf("Reversed (SB): %s\n", sbReverser.reverse(A));

  }

}