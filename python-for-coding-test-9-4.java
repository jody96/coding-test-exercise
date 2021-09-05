import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      final int INF = (int)1e9;
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] graph = new int[n+1][n+1];

      for(int i=1; i<=n; i++){
        Arrays.fill(graph[i], INF); 
      }

      for(int i=1; i<=n; i++){
        graph[i][i] = 0;
      }

      for(int i=0; i<m; i++){
        int a = sc.nextInt();
        int b = sc.nextInt();
        graph[a][b] = 1;
        graph[b][a] = 1;
      }

      for(int k=1; k<=n; k++){
        for(int a=1; a<=n; a++){
          for(int b=1; b<=n; b++){
            graph[a][b] = Math.min(graph[a][k]+graph[k][b], graph[a][b]);
          }
        }
      }
      int x = sc.nextInt();
      int k = sc.nextInt();
      int answer = graph[1][k] + graph[k][x];
      if(answer >= INF){
        System.out.println(-1);
      } else{
        System.out.println(answer);
      }
  }
}
