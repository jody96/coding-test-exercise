import java.util.*;
import java.io.*;
class Point implements Comparable<Point>{
  int x;
  int y;

  Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point other){
    if(this.x == other.x){
      return this.y - other.y;
    }
    return this.x - other.x;
  }
}
class Group implements Comparable<Group>{
  int numberBlock;
  int numberRainbow;
  Point standard;
  ArrayList<Point> members;  

  Group(int r, Point p, ArrayList<Point> arr){
    this.numberBlock = arr.size();
    this.numberRainbow = r;
    this.standard = p;
    this.members = arr;
  }
  
  @Override
  public int compareTo(Group other){
    if(this.numberBlock == other.numberBlock){
      if(this.numberRainbow == other.numberRainbow){
        if(this.standard.x == other.standard.x){
          return other.standard.y - this.standard.y;
        }
        return other.standard.x - this.standard.x;
      }
      return other.numberRainbow - this.numberRainbow;
    }
    return other.numberBlock -this.numberBlock;
  }
}

class Main {
  public static int n, m;
  public static int[][] graph;
  public static boolean[][] visited;
  public static int[][] vectors = {{-1,0},{0,1},{1,0},{0,-1}};
  public static PriorityQueue<Group> groups;
  public static int score = 0;
  public static void BFS(int si, int sj){
    ArrayList<Point> members = new ArrayList<>();
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(si, sj));
    members.add(new Point(si, sj));
    visited[si][sj] = true;    
    int numberRainbow = 0;
    ArrayList<Point> rainbows = new ArrayList<>();
    while(!queue.isEmpty()){
      Point curr = queue.poll();
      int currX = curr.x;
      int currY = curr.y;
      for(int d=0; d<4; d++){
        int ni = currX + vectors[d][0];
        int nj = currY + vectors[d][1];

        if(ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj])
          continue;
        if(graph[ni][nj] != graph[si][sj]){
          if(graph[ni][nj] == 0){
            numberRainbow++;
            rainbows.add(new Point(ni, nj));
          }
          else
            continue;
        }
        members.add(new Point(ni, nj));
        visited[ni][nj] = true;
        queue.add(new Point(ni, nj));
      }
    }
    if(members.size() >= 2){
      Collections.sort(members);
      Point s = new Point(0,0);
      for(int i=0; i<members.size(); i++){
        s = members.get(i);
        if(graph[s.x][s.y] != 0)
          break;
      }
      groups.add(new Group(numberRainbow, s, members));
    }
    if(numberRainbow > 0){
      for(int i=0; i<rainbows.size(); i++){
        Point rb = rainbows.get(i);
        visited[rb.x][rb.y] = false;
      }
    }
  }
  public static void turn(){
    int[][] newGraph = new int[n+1][n+1];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        newGraph[i][j] = graph[n-j-1][i];
      }
    }
    graph = newGraph;
  }
  public static void gravity(){
    for(int i=0; i<n; i++){
      for(int j=n-1; j>0; j--){
        if(graph[j][i] == -2){
          for(int k=j-1; k>=0; k--){
            if(graph[k][i] == -1)
              break;
            else if(graph[k][i] >= 0){
              graph[j][i] = graph[k][i];
              graph[k][i] = -2;
              break;
            }
          }
        }
      }
    }
  }
  /*
  public static void showGraph(){
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          System.out.print(graph[i][j] + "  ");
        }
        System.out.println();
      }
  }
  */
  public static void process(){
    while(true){
      groups = new PriorityQueue<>();
      visited = new boolean[n+1][n+1];
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          if(graph[i][j] > 0){
            BFS(i, j);   
          }
        }
      }
      if(groups.size() <= 0)
        break;
      Group selected = groups.poll();
      
      ArrayList<Point> members = selected.members;
      int mSize = members.size();
      score += (mSize * mSize);
      for(int i=0; i<members.size(); i++){
        int x = members.get(i).x;
        int y = members.get(i).y;
        graph[x][y] = -2;
      }
      gravity();
      for(int t=0; t<3; t++)
        turn();
      gravity();  
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new int[n+1][n+1];
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<n; j++){
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    process();
    System.out.println(score);
  }
}
