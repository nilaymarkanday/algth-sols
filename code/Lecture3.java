public class Lecture3 {
  public static void main(String[] args) {
    list = new int[] {10, 2, 3, 4, 5};
    System.out.println(p(0, 2));
  }

  public static int[] list;

  public static int g(int i, int j) {
    if (i == j) {
      return list[2 * i];
    }

    return g(i, j - 1) + list[2 * j - 1] + g(j, j);
  }

  public static int p(int i, int j) {
    if (i == j) {
      return 0;
    }

    int min = Integer.MAX_VALUE;

    for (int l = i + 1; l <= j; l++) {
      int temp = p(i, l - 1) + p(l, j);

      if (temp < min) {
        min = temp;
      }
    }

    return g(i, j) + min;

  }
}