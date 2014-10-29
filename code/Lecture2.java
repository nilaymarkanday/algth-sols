import java.util.HashMap;

public class Lecture2 {
  public static void main(String[] args) {
    System.out.println(paths(Integer.parseInt(args[0])));
  }

  public static int paths(int n) {
    cache = new HashMap<String, Integer>();
    return paths(n, n);
  }

  public static int paths(int x, int y) {
    if (y < 0) return 0;
    if (y > x) return 0;
    if (x == 0) return 1;

    String key = x + "|" + y;
    if (cache.containsKey(key)) return cache.get(key);

    int paths = 0;
    for (int i = 0; i <= y; i++) {
      paths += paths(x - 1, i);
    }

    for (int j = 0; j <= x; j++) {
      paths += paths(j, y - 1);
    } 

    paths -= paths(x - 1, y - 1);

    cache.put(key, paths);
    return paths;
  }

  public static HashMap<String, Integer> cache;
}