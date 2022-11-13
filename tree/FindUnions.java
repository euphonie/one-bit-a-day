package tree;

import java.util.Arrays;
import java.util.logging.Logger;

interface UnionFindStrategy {
  void buildUnionFindGraph(Integer n);

  boolean isConnected(int p, int q);

  void createUnion(int p, int q);

  String getGraph();
}

class WeightedQuickUnionSolver implements UnionFindStrategy {
  /**
   * Quick union defining trees out of recursively finding
   * the parent of i as id[..id[..id[i]..]..].
   *         [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
   * array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
   *
   * Executing union (3, 6) will result in id[3] = root(6)
   *         [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
   * array = [0, 1, 2, 6, 4, 5, 6, 7, 8, 9]
   *
   * Tree would look like
   *
   *   0 1 2   4 5 6 7 8 9
   *              /
   *             3
   * And finding connectivity is a matter of evaluating root(p) == root(q)
   */
  private int[] id;
  private int[] sz;

  @Override
  public void buildUnionFindGraph(Integer n) {
    id = new int[n];
    sz = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  @Override public boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  private int root(int i) {
    while (i != id[i]) {
      id[i] = id[id[i]]; // with path compression

      i = id[i];
    }
    return i;
  }

  @Override public void createUnion(int p, int q) {
    int i = root(p);
    int j = root(q);
    if ( i == j) return;
    if (sz[i] < sz[j]){
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
  }

  @Override public String getGraph() {
    return String.format(
        "Better find (lg N array accesses) - [Weighted Quick Union Implementation] %s",
        Arrays.toString(id)
    );
  }
}

class QuickUnionSolver implements UnionFindStrategy {
  /**
   * Quick union defining trees out of recursively finding
   * the parent of i as id[..id[..id[i]..]..].
   *         [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
   * array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
   *
   * Executing union (3, 6) will result in id[3] = root(6)
   *         [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
   * array = [0, 1, 2, 6, 4, 5, 6, 7, 8, 9]
   *
   * Tree would look like
   *
   *   0 1 2   4 5 6 7 8 9
   *              /
   *             3
   * And finding connectivity is a matter of evaluating root(p) == root(q)
   */
  private int[] id;

  @Override
  public void buildUnionFindGraph(Integer n) {
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  @Override public boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  private int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }

  @Override public void createUnion(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }

  @Override public String getGraph() {
    return String.format(
        "Expensive find (N array accesses) - [Quick Union Implementation] %s",
        Arrays.toString(id)
    );
  }
}


class QuickFindUnionSolver implements UnionFindStrategy {
  // Approach 1: quick find
  // array int[], edges are connected if they have same value. E.g.
  //         [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
  // array = [0, 1, 1, 8, 8, 0, 0, 1, 8, 8]
  // 1, 6, 7 are connected
  // 2, 3, 8 are connected
  // 4, 5, 9 are connected
  // check if p and q have same value
  //
  // merging: change all ids that had old value to new. E.g.
  // 0 is now connected to 1
  //         [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
  // array = [1, 1, 1, 8, 8, 1, 1, 1, 8, 8]
  private int[] id;

  @Override
  public void buildUnionFindGraph(Integer n) {
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  @Override
  public boolean isConnected(int p, int q) {
    return id[p] == id[q];
  }

  @Override
  public void createUnion(int p, int q) {
    if (isConnected(p, q)) {
      return;
    }
    int groupIdP = id[p];
    int groupIdQ = id[q];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == groupIdP) {
        id[i] = groupIdQ;
      }
    }
  }

  @Override
  public String getGraph() {
    return String.format(
        "Expensive union (N array accesses) - [Quick Find Implementation] %s",
        Arrays.toString(id)
    );
  }
}

/**
 * a.
 */
public class FindUnions {

  private static final Logger log = Logger.getLogger(String.valueOf(FindUnions.class));

  /**
   * a.
   *
   * @param args b.
   */
  public static void main(String[] args) {

    int n = 10;
    UnionFindStrategy solver = new WeightedQuickUnionSolver();
    solver.buildUnionFindGraph(n);
    solver.createUnion(4, 3);
    solver.createUnion(3, 8);
    solver.createUnion(6, 5);
    solver.createUnion(9, 4);
    solver.createUnion(2, 1);
    solver.createUnion(8, 9);
    solver.createUnion(5, 0);
    solver.createUnion(7, 2);
    solver.createUnion(6, 1);
    solver.createUnion(1, 0);

    log.info(
        String.valueOf(solver.isConnected(4, 1))
    );
    log.info(
        String.valueOf(solver.isConnected(2, 7))
    );

    log.info(solver.getGraph());
  }

}
