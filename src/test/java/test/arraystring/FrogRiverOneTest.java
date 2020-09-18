package test.arraystring;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FrogRiverOneTest {


  @Test
  public void test1() {
    int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
    int X = 5;

    int result = frogTime(A, X);
    assertThat(result, is(6));

  }

  @Test
  public void test3() {
    int[] A = {1};
    int X = 1;

    int result = frogTime(A, X);
    assertThat(result, is(0));

  }

  private int frogTime(int[] A, int X) {
    Set<Integer> distance = new HashSet<>();

    for (int i = 0; i < A.length; i++) {
      if (A[i] <= X) {
        distance.add(A[i]);
        if (distance.size() == X) {
          return i;
        }
      }
    }

    return -1;
  }

}