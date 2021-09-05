import java.util.*;
import java.io.*;
class Main {
  static int[][] vector = {{0,-1},{-1,0}, {0,1},{1,0}};
  static int n;
  static int m;
  static boolean[][] visited;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    
    int[][] map = new int[n][m];
    visited = new boolean[n][m];

    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    visited[a][b] = true;
    
    while(true){
      int[] temp;
      if(allVisited(a, b, map)){
        temp = moveBehind(d, a, b, map);
        if((temp[0] == a) && (temp[1] == b)){
          break;
        }
      } else{
        temp = turnLeftAndGo(d, a, b, map);
        d = turnLeft(d);
      }
      a = temp[0];
      b = temp[1];
      visited[a][b] = true;
    }

    int ans = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(visited[i][j]){
          ans++;
        }
      }
    }
    
    System.out.println(ans);
  }
  public static boolean allVisited(int x, int y, int[][] map){
    
    for(int i=0; i<4; i++){
      int tx = x + vector[i][0];
      int ty = y + vector[i][1];

      if(map[tx][ty] == 0 && !visited[tx][ty])
        return false;
    }
    return true;
  }
  public static int turnLeft(int d){
        int ret = d - 1;
        if(ret < 0)
          ret = 3;

        return ret;
  }
  public static int[] turnLeftAndGo(int d, int x, int y, int[][] map){
        int tx = x;
        int ty = y;
        int[] ret = new int[2];
        ret[0] = x;
        ret[1] = y;
        switch(d){
      //{{0,-1},{-1,0}, {0,1},{1,0}};
        case 0: 
          tx += vector[0][0];
          ty += vector[0][1];
          break;
        case 1: 
          tx += vector[1][0];
          ty += vector[1][1];
          break;
        case 2: 
          tx += vector[2][0];
          ty += vector[2][1];
          break;
        case 3: 
          tx += vector[3][0];
          ty += vector[3][1];
          break;
      }
      if(map[tx][ty] != 1 && !visited[tx][ty]){
        ret[0] = tx;
        ret[1] = ty;  
      }
      return ret;
  }

  public static int[] moveBehind(int d, int x, int y, int[][] map){
        int nx = x;
        int ny = y;
        int[] ret = new int[2];
        ret[0] = x;
        ret[1] = y;
        //{{0,-1},{-1,0}, {0,1},{1,0}};
        switch(d){
        case 0: 
          nx += vector[3][0];
          ny += vector[3][1];
          break;
        case 1: 
          nx += vector[0][0];
          ny += vector[0][1];
          break;
        case 2: 
          nx += vector[1][0];
          ny += vector[1][1];
          break;
        case 3: 
          nx += vector[2][0];
          ny += vector[2][1];
          break;
      }
      if(map[nx][ny] != 1){
        ret[0] = nx;
        ret[1] = ny; 
      }
      return ret;
  }
  
}
