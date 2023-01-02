package strings;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ReverseStringTest {

  public static StringReverser reverser;

  @Before
  public void setup(){
    StringReverser.BeteReverseStrategy strategy = new StringReverser.BeteReverseStrategy();
    reverser = new StringReverser(strategy);
  }

  @Test
  public void reverseOneLetterString() {
    assertEquals("a", reverser.reverse("a"));
  }

  @Test
  public void reverseEvenShortString() {
    assertEquals("ab", reverser.reverse("ba"));
  }

  @Test
  public void reverseUnevenShortString() {
    assertEquals("acb", reverser.reverse("bca"));
  }

  @Test(timeout = 5)
  public void reverseLongString() {
    assertEquals("123456789123456789123456789123456789",
        reverser.reverse("987654321987654321987654321987654321"));
  }
}
