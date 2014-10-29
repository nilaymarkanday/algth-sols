
public class Lecture3 {
  public static void main(String[] args) {
    // String s1 = "informatics";
    // String s2 = "interpolation";

    System.out.println("Edit distance is: " + editDistance(args[0], args[1]));
  }

  public static int editDistance(String s1, String s2) {
    int[][] costs = new int[s1.length() + 1][s2.length() + 1];

    for (int j = 0; j < s2.length() + 1; j++) {
      costs[0][j] = j;
    }

    for (int i = 0; i < s1.length() + 1; i++) {
      costs[i][0] = i;
    }


    for (int i = 1; i < s1.length() + 1; i++) {
      for (int j = 1; j < s2.length() + 1; j++) {
        int up = costs[i - 1][j] + 1, left = costs[i][j - 1] + 1, diagonal = costs[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1);
        int min = 0;
        if (up <= left && up <= diagonal) {
          min = up;
        } else if (left <= up && left <= diagonal) {
          min = left;
        } else {
          min = diagonal;
        }

        costs[i][j] = min;
      }
    }

    return costs[s1.length()][s2.length()];
  }
}