package hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicatesTest {
  
  @Test
  public void shouldFindOneDuplicate() {
    FindDuplicates finder = new FindDuplicates();
    assertEquals(
        true,
        finder.containsDuplicate(new int[]{1, 2, 3, 1})
    );
  }

  @Test
  public void shouldNotFindDuplicates() {
    FindDuplicates finder = new FindDuplicates();
    assertEquals(
        false,
        finder.containsDuplicate(new int[]{1,2,3,4})
    );
  }

  @Test
  public void shouldFindMultipleDuplicates() {
    FindDuplicates finder = new FindDuplicates();
    assertEquals(
        true,
        finder.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})
    );
  }

}