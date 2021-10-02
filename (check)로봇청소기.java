import java.util.*;
class Main {
  public static int n,m;
  public static int[][] graph = new int[51][51];
  public static int rx;
  public static int ry;
  public static int dir;
  public static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}}; 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    rx = sc.nextInt();
    ry = sc.nextInt();
    dir = sc.nextInt();
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        graph[i][j] = sc.nextInt();
      }
    }
    int cnt = 1;
    graph[rx][ry] = -1;
    while(true){
      int turn = 0;
      while(turn < 4){
        turn++;
        dir = (dir + 3) % 4;
        int nx = rx + vector[dir][0];
        int ny = ry + vector[dir][1];
        if(graph[nx][ny] == 0){
          rx = nx;
          ry = ny;
          System.out.println(rx + " "+ ry);
          graph[rx][ry] = -1;
          cnt++;
          break;
        }
      }
      
      if(turn == 4){
        int back = (dir + 2) % 4;
        int nx = rx + vector[back][0];
        int ny = ry + vector[back][1];
        if(graph[nx][ny] == -1){
          rx = nx;
          ry = ny;
        } else{
          break;
        }
      }
    }
    System.out.println(cnt);
  }
}
