package strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Logger;

public class ReverseStringInParenthesis {

  private static final Logger log = Logger.getLogger(
      String.valueOf(ReverseStringInParenthesis.class));

  public static void reverse(char[] A, int l, int h) {
    if (l < h) {
      char c = A[l];
      A[l] = A[h];
      A[h] = c;
      reverse(A, l + 1, h - 1);
    }
  }

  public static String reverseContent(String s){
    Deque<Integer> st = new ArrayDeque<>();
    int len = s.length() -1;
    for (int i =0; i < len; i++) {
      if (s.charAt(i) == '(') {
        st.push(i);
      } else if (s.charAt(i) == ')') {
        char[] A = s.toCharArray();
        if (st.peek() == null) {
          throw new IllegalArgumentException("malformed string");
        }
        reverse(A, st.peek() + 1, i);
        s = String.copyValueOf(A);
        st.pop();
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i =0; i< len; i++){
      if (s.charAt(i) != ')' && s.charAt(i) != '(') {
        result.append(s.charAt(i));
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String expression = "(abc(fed)ghi)";

    String solution = reverseContent(expression);
    log.info(solution);

  }
}
