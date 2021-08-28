import java.util.*;
import java.io.*;
class Main {
  public static int n;
  public static int m;
  public static int[][] graph;
  public static int[][] vector = {{0,1},{1,0},{0,-1},{-1,0}};
  public static class Person{
    int x;
    int y;
    int len;

    Person(int x, int y, int len){
      this.x = x;
      this.y = y;
      this.len = len;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new int[n+1][m+1];
    
    for(int i=1; i<=n; i++){
      String str = br.readLine();
      for(int j=1; j<=m; j++){
        graph[i][j] = str.charAt(j-1) - '0';
      }
    }

    int answer = bfs();
    System.out.println(answer);
  }
  public static int bfs(){
    Queue<Person> queue = new LinkedList<>();
    queue.add(new Person(1,1,1));
    boolean[][] visited = new boolean[n+1][m+1];
    visited[1][1] = true;
    while(!queue.isEmpty()){
      Person curr = queue.remove();
      int curx = curr.x;
      int cury = curr.y;
      int curl = curr.len;
      if((curx == n) && (cury == m)){
        return curl;
      }
      for(int i=0; i<4; i++){
        int nr = curx + vector[i][0];
        int nc = cury + vector[i][1];

        if(nr <=0 || nr > n || nc <=0 || nc > m)
          continue;
        if((graph[nr][nc] == 0) || visited[nr][nc])
          continue;
        visited[nr][nc] = true;
        queue.add(new Person(nr, nc, curl+1));
      }
    }
    return -1;
  }
}
