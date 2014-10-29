import java.io.BufferedReader;
import java.io.FileReader;

public class Lecture3 {
  public static void main(String[] args) throws Exception {
    
    processPyramid(readDataIntoPyramid("Lecture3.data.txt"));
  }

  public static void processPyramid(int height) {
    for (int i = height - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        pyramid[i][j] += (pyramid[i + 1][j] > pyramid[i + 1][j + 1] ? pyramid[i + 1][j] : pyramid[i + 1][j + 1]);
      }
    }

    System.out.println(pyramid[0][0]);
  }

  public static void printPyramid() {
    for (int[] row : pyramid) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }

      System.out.println();
    }
  }

  public static int readDataIntoPyramid(String file) throws Exception {
    pyramid = new int[100][100];
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;

    int i = 0;
    while ((line = br.readLine()) != null) {
      String[] strData = line.split(" ");

      int j = 0;
      for (String strNum : strData) {
        pyramid[i][j++] = Integer.parseInt(strNum);
      }

      i++;
    }

    return i;
  }

  public static int[][] pyramid;

}