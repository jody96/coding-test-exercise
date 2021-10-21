import java.util.*;
import java.io.*;
class Main {
  public static int n, m;
  public static int max = Integer.MIN_VALUE;
  public static int[][] graph = new int[501][501];
  public static int[][] vectors = {{0,1},{1,0},{0,-1},{-1,0}};
  public static boolean[][] visited = new boolean[501][501];
  public static void DFS(int i, int j, int depth, int sum){
    if(depth == 4){
      max = Math.max(max, sum);
      return;
    }
    for(int k=0; k<4; k++){
      int ni = i + vectors[k][0];
      int nj = j + vectors[k][1];
      if(ni < 0 || ni >= n || nj < 0 || nj >= m)
        continue;
      if(visited[ni][nj])
        continue;
      visited[i][j] = true;
      DFS(ni, nj, depth+1, sum + graph[i][j]);
      visited[i][j] = false;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; j++){
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        DFS(i, j, 0, 0);
      }
    }
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        int sum = graph[i][j];
        if((i == 0 && j == 0) || (i == 0 && j == m-1) || (i == n-1 && j == 0) || 
        (i == n-1 && j == m-1)){
          continue;
        }
        else if(i == 0){
          sum += (graph[i][j-1] + graph[i][j+1] + graph[i+1][j]);
        }
        else if(j == 0){
          sum += (graph[i-1][j] + graph[i+1][j] + graph[i][j+1]);
        }
        else if(i == n-1){
          sum += (graph[i][j-1] + graph[i][j+1] + graph[i-1][j]);
        } 
        else if(j == m - 1){
          sum += (graph[i-1][j] + graph[i+1][j] + graph[i][j-1]);
        }
        else {
          int min = Integer.MAX_VALUE;
          for(int k=0; k<4; k++){
            int ni = i + vectors[k][0];
            int nj = j + vectors[k][1];
            min = Math.min(min, graph[ni][nj]);
            sum += graph[ni][nj];
          }
          sum -= min;
        }
        max = Math.max(max, sum);
      }
    }
    System.out.println(max);
  }
}
