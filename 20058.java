import java.util.*;
import java.io.*;
class Point{
  int x;
  int y;
  
  Point(int x, int y){
    this.x = x;
    this.y = y;
  }
}
class Main {
  public static int n, q;
  public static int len;
  public static int[][] graph;
  public static int max = Integer.MIN_VALUE;
  public static ArrayList<Integer> steps = new ArrayList<>();
  public static int[][] vectors = {{-1,0},{0,1},{1,0},{0,-1}};
  public static boolean[][] visited = new boolean[501][501];
  public static void BFS(int sx, int sy){
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(sx, sy));
    visited[sx][sy] = true;
    int cnt = 1;
    while(!queue.isEmpty()){
      Point curr = queue.remove();
      for(int i=0; i<4; i++){
        int nx = curr.x + vectors[i][0];
        int ny = curr.y + vectors[i][1];
        if(nx < 0 || nx >= len || ny < 0 || ny >= len)
          continue;
        if(visited[nx][ny])
          continue;
        visited[nx][ny] = true;
        cnt++;
        queue.add(new Point(nx, ny));
      }
    }
    max = Math.max(max, cnt);
  }
  public static boolean check(int x, int y){
    int cnt = 0;
    for(int i=0; i<4; i++){
      int nx = x + vectors[i][0];
      int ny = y + vectors[i][1];
      if(nx < 0 || nx > len || ny <0 || ny > len)
        continue;
      if(graph[nx][ny] > 0){
        cnt++;
      }
    }
    if(cnt >= 3){
      return true;
    }
    return false;
  }
  public static void fire(){
    for(int i=0; i<len; i++){
      for(int j=0; j<len; j++){
        if(graph[i][j] != 0 && !check(i,j)){
          graph[i][j]--;
        }
      }
    }
  }
  public static void process(int step){
    int[][] newGraph = new int[len][len];
    int l = (int)Math.pow(2, step);
    for(int i=0; i<len; i++){
      for(int j=0; j<len; j++){
        int ni = Math.abs(j-l);
        int nj = 
        newGraph[Math.abs(j-l)][2*l-i-1] = graph[i][j]; 
      }
    }
    graph = newGraph;
    fire();
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());
    
    len = (int)Math.pow(2, n);
    graph = new int[len][len];
    
    for(int i=0; i<len; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<len; j++){
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<q; i++){
      steps.add(Integer.parseInt(st.nextToken()));
    }
    for(int i=0; i<q; i++){
      process(steps.get(i));
    }
    int sum = 0;
    for(int i=0; i<len; i++){
      for(int j=0; j<len; j++){
        if(graph[i][j] > 0){
          sum += graph[i][j];
          if(!visited[i][j])
          BFS(i, j);
        }
      }
    }
    System.out.println(sum);
    System.out.println(max);
  }
}
