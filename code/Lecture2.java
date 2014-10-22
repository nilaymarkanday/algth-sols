
public class Lecture2 {

  public static int[] d;
  public static int[][] s;
  public static int[][] cache;

  public static int m(int[] dims) {
    d = dims;
    return m(1, d.length - 1);
  }

  public static int m(int i, int j) {
    if (s == null) {
      int m = d.length - 1;
      s = new int[m][m];
      cache = new int[m][m];
    }

    if (i == j) {
      return 0;
    }

    if (cache[i - 1][j - 1] != 0) {
      return cache[i - 1][j - 1];
    }

    int mm = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int t = m(i, k) + m(k + 1, j) + d[i - 1] * d[k] * d[j];

      if (t < mm) {
        mm = t;
        s[i - 1][j - 1] = k;
      }
    }

    cache[i - 1][j - 1] = mm;
    return mm;
  }



  public static void main(String[] args) {
    System.out.println(m(new int[] {30, 35, 15, 5, 10, 20, 25, 30, 35, 15, 5, 10, 20, 25, 30, 35, 15, 5, 10, 20, 25, 30, 35, 15, 5, 10, 20, 25}));
  }
}