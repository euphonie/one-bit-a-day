package strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class RemoveAdjacentDuplicates {
  public static String removeDuplicates(String s) {
    Deque<Character> matches = new ArrayDeque();

    int n = s.length();
    matches.add(s.charAt(0));
    for(int i =1; i < n; i++) {
      char c = s.charAt(i);
      if (matches.peek() == null || matches.peek() != s.charAt(i)) {
        matches.addFirst(c);
      } else {
        matches.pop();
      }
    }
    Iterator<Character> iter = matches.descendingIterator();
    StringBuilder sb = new StringBuilder();
    while(iter.hasNext()) { sb.append(iter.next()); }
    return sb.toString();
  }

  public static void main(String[] args){
    System.out.println(removeDuplicates("abbaca"));
  }
}
