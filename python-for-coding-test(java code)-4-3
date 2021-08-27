import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int[][] vector = {{-1,2}, {-1,-2}, {1,2},{1,-2}, {2,1},{2,-1}, {-2,1},{-2,-1}};
    
    String position = br.readLine();
    int col = (int)(position.charAt(0) - 'a');
    int row = (int)(position.charAt(1) - '1');
    
    int ans = 0;
    for(int i=0; i<8; i++){
      int nr = row + vector[i][0];
      int nc = col + vector[i][1];

      if(nr < 0 || nr >= 8 || nc < 0 || nc >= 8)
        continue;
      ans++;
    }
    System.out.println(ans);
  }
}
