import java.math.BigInteger;
import static java.math.BigInteger.*;

import java.util.Scanner;

public class Lecture1 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter n: ");
    int i = scanner.nextInt();

    // print(identity(new int[i][i]));
    System.out.println(a(big(i)));
  }

  // a) int 
  public static int[][] power(int[][] m, int n) {
    if (n == 0) 
      return identity(m);
    else if (n == 1) 
      return m;
    else if (n % 2 == 0)
      return power(multiply(m, m), n / 2);
    else
      return multiply(power(multiply(m, m), (n - 1) / 2), m);
  }

  public static int[][] multiply(int[][] a, int[][] b) {
    int[][] c = new int[a.length][a.length];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        for (int k = 0; k < a.length; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    return c;
  }

  // a) BigInteger
  public static BigInteger[][] power(BigInteger[][] m, BigInteger n) {
    if (n.compareTo(ZERO) == 0) 
      return identity(m);
    else if (n.compareTo(ONE) == 0) 
      return m;
    else if (n.mod(BigInteger.valueOf(2)).compareTo(ZERO) == 0)
      return power(multiply(m, m), n.divide(BigInteger.valueOf(2)));
    else
      return multiply(power(multiply(m, m), n.subtract(ONE).divide(BigInteger.valueOf(2))), m);
  }

  public static BigInteger[][] multiply(BigInteger[][] a, BigInteger[][] b) {
    BigInteger[][] c = new BigInteger[a.length][a.length];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        for (int k = 0; k < a.length; k++) {
          if (c[i][j] == null) {
            c[i][j] = ZERO;
          }

          c[i][j] = c[i][j].add(a[i][k].multiply(b[k][j]));
        }
      }
    }

    return c;
  }

  // b)
  public static BigInteger[] multiply(BigInteger[][] m, BigInteger[] s) {
    BigInteger[] r = new BigInteger[m.length];

    for (int i = 0; i < m.length; i++) {
      for (int k = 0; k < m.length; k++) {
        if (r[i] == null) {
          r[i] = ZERO;
        }

        r[i] = r[i].add(m[i][k].multiply(s[k]));
      }
    }

    return r;
  }

  public static BigInteger a(BigInteger n) {
    BigInteger[][] m = new BigInteger[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        m[i][j] = ZERO;
      }
    }

    m[0][1] = m[1][2] = m[2][0] = m[2][2] = ONE;   

    BigInteger[] v = new BigInteger[3];
    v[0] = ONE;
    v[1] = BigInteger.valueOf(2);
    v[2] = BigInteger.valueOf(3);

    return multiply(power(m, n), v)[0];
  }

  // Helper methods
  public static BigInteger big(int i) {
    // just a quick abbrev
    return BigInteger.valueOf(i);
  }
  public static void print(BigInteger[][] m) {
    for (BigInteger[] r : m) {
      for (BigInteger c : r) {
        System.out.print(c + " ");
      }
      System.out.println();
    }

    System.out.println();
  }

  public static void print(BigInteger[] m) {
    for (BigInteger c : m) {
      System.out.println(c + " ");
    }
    System.out.println();
  }

  public static BigInteger[][] identity(BigInteger[][] m) {
    int l = m.length;
    BigInteger[][] id = new BigInteger[l][l];

    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        id[i][j] = i == j ? ONE : ZERO;
      }
    }
    return id;
  }

  // Helper methods - int
  public static void print(int[][] m) {
    for (int[] r : m) {
      for (int c : r) {
        System.out.print(c + " ");
      }
      System.out.println();
    }

    System.out.println();
  }

  public static int[][] identity(int[][] m) {
    int l = m.length;
    int[][] id = new int[l][l];

    for (int i = 0; i < l; i++) {
      id[i][i] = 1;
    }

    return id;
  } 
}