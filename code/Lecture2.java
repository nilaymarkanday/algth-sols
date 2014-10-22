import java.util.HashMap;

public class Lecture2 {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]), k = Integer.parseInt(args[1]);
    System.out.println(partitions(n, k));
  }

  public static long[] factorialCache;
  public static long[][] binomialCache;
  public static HashMap<String, Long> cache;

  public static long partitions(int n, int k) {
    factorialCache = new long[n + 1];
    binomialCache = new long[n + 1][n + 1];
    cache = new HashMap<String, Long>();
    return g(1, n, k);
  }

  public static long g(int b, int n, int k) {
    if (b < 0) {
      return 0;
    }

    if (b == 0 || n == 0 || k < 2) {
      return 1;
    }

    String key = b + "|" + n + "|" + k;

    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    if (b >= n) {
      long sum = 0;
      for (int t = 1; t <= n + 1; t++) {
        int sign = t % 2 == 0 ? -1 : 1;
        sum += binomial(n + 1, t) * g(b - t, n, k) * sign;
      }

      cache.put(key, sum);
      return sum;
    } else {
      long r = g(b - 1, n, k) + g(b * k, n - 1, k);
      cache.put(key, r);
      return r;
    }
  }

  public static long binomial(int n, int k) {
    if (binomialCache[n][k] != 0) {
      return binomialCache[n][k];
    }

    long f = factorial(n) / (factorial(k) * factorial(n - k));
    binomialCache[n][k] = f;
    return f;
  }

  public static long factorial(int l) {

    if (l == 0) 
      return 1;

    if (factorialCache[l] != 0) {
      return factorialCache[l];
    }

    long f = l;
    while (l-- > 1) {
      f *= l;
    }

    factorialCache[l] = f;
    return f;
  }
}