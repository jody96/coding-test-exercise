import java.util.*;
class Position{
  private int x;
  private int y;

  Position(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
}
class Main {
  public static int n, L, R;
  public static int[][] graph = new int[50][50];
  public static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}};
  public static boolean[][] visited = new boolean[50][50];
  public static ArrayList<Position> BFS(int x, int y){
    Queue<Position> queue = new LinkedList<>();
    queue.add(new Position(x, y));
    visited[x][y] = true;    
    ArrayList<Position> temp = new ArrayList<>();
    temp.add(new Position(x, y));
    while(!queue.isEmpty()){
      Position curr = queue.poll();
      int curX = curr.getX();
      int curY = curr.getY();

      for(int i=0; i<4; i++){
        int nx = curX + vector[i][0];
        int ny = curY + vector[i][1];
        
        if(nx >= n || nx < 0 || ny >= n || ny <0)
          continue;
        if(visited[nx][ny])
          continue;
        int diff = Math.abs(graph[nx][ny] - graph[curX][curY]);
        if(L <= diff && diff <= R){
          visited[nx][ny] = true;
          queue.add(new Position(nx, ny));
          temp.add(new Position(nx, ny));
        }
      }
    }
    return temp;
  }
  
  public static void process(ArrayList<Position> arr){
    int sum = 0;
    for(int i=0; i<arr.size(); i++){
      sum += graph[arr.get(i).getX()][arr.get(i).getY()];
    }
    int average = sum / arr.size();

    for(int i=0; i<arr.size(); i++){
      int x = arr.get(i).getX();
      int y = arr.get(i).getY();

      graph[x][y] = average;
    }
  }

  public static boolean checkUnion(int r, int c){
    for(int i=0; i<4; i++){
      
      int nr = r + vector[i][0];
      int nc = c + vector[i][1];
      
      if(nr >= n || nr < 0 || nc >= n || nc <0)
        continue;

      int diff = Math.abs(graph[nr][nc] - graph[r][c]);

      if((L <= diff) && (diff <= R)){
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    L = sc.nextInt();
    R = sc.nextInt();

    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        graph[i][j] = sc.nextInt();
      }
    }
    int answer = 0;
    boolean flag = true;
    while(flag){
      flag = false;
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          if(visited[i][j])
            continue;
          if(checkUnion(i, j)){
            flag = true;
            process(BFS(i, j));
          }
        }
      }
      if(flag)
        answer++;
      visited = new boolean[50][50];
    }
    
    System.out.println(answer);
  }
}
