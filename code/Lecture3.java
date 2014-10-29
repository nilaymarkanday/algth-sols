import java.util.HashMap;

public class Lecture3 {
  public static void main(String[] args) {
    list = new int[] {10, 2, 3, 4, 5};
    p = new HashMap<String, Integer>();
    g = new HashMap<String, Integer>();

    System.out.println(p(0, 2));
  }

  public static int[] list;

  public static int g(int i, int j) {
    if (i == j) {
      return list[2 * i];
    }

    String key = i + "|" + j;
    if (g.containsKey(key)) return g.get(key);

    g.put(key, g(i, j - 1) + list[2 * j - 1] + g(j, j));
    return g.get(key);
  }

  public static int p(int i, int j) {
    if (i == j) {
      return 0;
    }

    String key = i + "|" + j;
    if (p.containsKey(key)) return p.get(key);

    int min = Integer.MAX_VALUE;

    for (int l = i + 1; l <= j; l++) {
      int temp = p(i, l - 1) + p(l, j);

      if (temp < min) {
        min = temp;
      }
    }

    p.put(key, g(i, j) + min);
    return p.get(key);
  }

  public static HashMap<String, Integer> p, g;
}