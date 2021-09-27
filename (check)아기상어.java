import java.util.*;
class Fish {
  private int x;
  private int y;
  private int distance;
  
  public Fish(int x, int y, int distance){
    this.x = x;
    this.y = y;
    this.distance = distance;
  }

  public int getX(){
    return this.x;
  } 
  public int getY(){
    return this.y;
  }
  public int getDistance(){
    return this.distance;
  }
}

class Main {
  public static int n;
  public static int[][] graph = new int[20][20];
  public static int sharkX;
  public static int sharkY;
  public static int sharkN = 2;
  public static int ate = 0;
  public static int result = 0;
  public static int[][] vectors = {{-1,0},{0,1},{1,0},{0,-1}};

  public static boolean BFS(){
    boolean[][] visited = new boolean[20][20];
    Fish shark = new Fish(sharkX, sharkY, 0);
    PriorityQueue<Fish> queue = new PriorityQueue<>(new Comparator<Fish>(){
      @Override
      public int compare(Fish f1, Fish f2){
        if(f1.getDistance() == f2.getDistance()){
          if(f1.getX() == f2.getX()){
            return f1.getY() - f2.getY();
          }
          return f1.getX() - f2.getX();
        }
        return f1.getDistance() - f2.getDistance();
      }
    });
    queue.add(shark);
    visited[sharkX][sharkY] = true;
    while(!queue.isEmpty()){
      Fish curr = queue.poll();
      sharkX = curr.getX();
      sharkY = curr.getY();
      int currD = curr.getDistance();
      if(graph[sharkX][sharkY] != 0 && graph[sharkX][sharkY] < sharkN){
        graph[sharkX][sharkY] = 0;
        ate++;
        result += currD;
        return true;
      }
      for(int i=0; i<4; i++){
        int nx = sharkX + vectors[i][0];
        int ny = sharkY + vectors[i][1];
        
        if(nx >= n || nx < 0 || ny >= n || ny < 0)
          continue;
        if(visited[nx][ny])
          continue;
        if(graph[nx][ny] > sharkN)
          continue;
        visited[nx][ny] = true;
        queue.add(new Fish(nx, ny, currD+1));
      }
    }
    return false;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        graph[i][j] = sc.nextInt();
        if(graph[i][j] == 9){
          sharkX = i;
          sharkY = j;
          graph[i][j] = 0;
        }
      }
    }
    
    while(true){ 
      if(!BFS())
        break;
      if(ate == sharkN){
        sharkN++;
        ate = 0;
      }
    }
    System.out.println(result);
  }
}
