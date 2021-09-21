import java.util.*;
class Main {
  public static int n, m;
  public static int[][] map = new int[8][8];
  public static int[][] modMap = new int[8][8];
  public static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}};
  public static int max = -1;
  public static void spread(int r, int c){
    for(int k=0; k<4; k++){
      int nr = r + vector[k][0];
      int nc = c + vector[k][1];
      if(nr < 0 || nr >= n || nc < 0 || nc >= m)
        continue;
      if(modMap[nr][nc] == 0){
        modMap[nr][nc] = 2;
        spread(nr, nc);
      }
    }
  } 
  public static void DFS(int depth){
    if(depth == 3){
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          modMap[i][j] = map[i][j];
        }
      }
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(modMap[i][j] == 2){
            spread(i, j);
          }
        }
      }
      int cnt = 0;
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(modMap[i][j] == 0){
            cnt++;
          }
        }
      }
      max = Math.max(max, cnt);
      return;
    }
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(map[i][j] == 0){
          map[i][j] = 1;
          DFS(depth+1);
          map[i][j] = 0;
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        map[i][j] = sc.nextInt();
      }
    }
    DFS(0);
    System.out.println(max);
  }
}
