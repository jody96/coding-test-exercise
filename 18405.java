import java.util.*;

class Virus implements Comparable<Virus>{
  private int kind;
  private int second;
  private int x;
  private int y;

  Virus(int kind, int second, int x, int y){
    this.kind = kind;
    this.second  = second;
    this.x = x;
    this.y = y;
  }

  public int getKind(){
    return kind;
  }
  public int getSecond(){
    return second;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }

  @Override
  public int compareTo(Virus other){
    if(this.second == other.second)
      return this.kind - other.kind;
    return this.second - other.second;
  }
}

class Main {
  public static int n, k, s, x, y;
  public static int[][] graph = new int[200][200];
  public static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}};
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();
    PriorityQueue<Virus> queue = new PriorityQueue<>();
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        graph[i][j] = sc.nextInt();
        if(graph[i][j] != 0)
          queue.add(new Virus(graph[i][j], 0, i, j));
      }
    }
    s = sc.nextInt();
    x = sc.nextInt();
    y = sc.nextInt();

    while(!queue.isEmpty()){
      Virus now = queue.poll();
      if(now.getSecond() == s)
        continue;
      for(int i=0; i<4; i++){
        int nx = now.getX() + vector[i][0];
        int ny = now.getY() + vector[i][1];
        if(nx >= n || nx < 0 || ny >= n || ny < 0)
          continue;
        if(graph[nx][ny] == 0){
          graph[nx][ny] = now.getKind();
          queue.add(new Virus(now.getKind(), now.getSecond()+1, nx, ny));
        }
      }
    }
    
    System.out.println(graph[x-1][y-1]);
  }
}
