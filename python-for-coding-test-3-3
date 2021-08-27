import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] cards = new int[n][m];
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      int min = Integer.MAX_VALUE;
      for(int j=0; j<m; j++){
        cards[i][j] = Integer.parseInt(st.nextToken());
        min = Math.min(min, cards[i][j]);
      }
      arr.add(min);
    }

    Collections.sort(arr, Collections.reverseOrder());

    System.out.println(arr.get(0));
  }
}
