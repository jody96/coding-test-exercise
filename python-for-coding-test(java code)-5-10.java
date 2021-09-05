import java.util.*;
import java.io.*;
class Main {
  static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}};
  static int n;
  static int m;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n][m];
    for(int i=0; i<n; i++){
      String str = br.readLine();
      for(int j=0; j<m; j++){
        map[i][j] = (str.charAt(j) - '0');
      }
    }

    int cnt = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(map[i][j] == 0){
          cnt++;
          DFS(map, i, j);
        }
      }
    } 
    System.out.println(cnt);
  }

  public static void DFS(int[][] map, int i, int j){
    for(int k=0; k<4; k++){
      int nr = i + vector[k][0];
      int nc = j + vector[k][1];
      if(nr <0 || nr >= n || nc <0 || nc >= m)
        continue;
      if(map[nr][nc] == 1)
        continue;

      map[nr][nc] = 1;
      DFS(map, nr, nc);
    }
  }
}
