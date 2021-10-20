import java.util.*;
import java.io.*;
class CCTV {
  int x;
  int y;
  int n;
  ArrayList<Integer> directions = new ArrayList<>();

  CCTV(int x, int y, int n){
    this.x = x;
    this.y = y;
    this.n = n;
    
    if(n == 1){
      directions.add(1);
    }
    else if(n == 2){
      directions.add(1);
      directions.add(3);
    }
    else if(n == 3){
      directions.add(0);
      directions.add(1);
    }
    else if(n == 4){
      directions.add(0);
      directions.add(1);
      directions.add(3);
    }
    else if(n == 5){
      directions.add(0);
      directions.add(1);
      directions.add(2);
      directions.add(3);
    }
  }
  void turn(){
    if(n < 5){
      for(int i=0; i<directions.size(); i++){
        directions.set(i, (directions.get(i) + 1) % 4); 
      }
    } 
  }
}
class Main {
  public static int n, m;
  public static int min = Integer.MAX_VALUE;
  public static int[][] vectors = {{-1,0},{0,1},{1,0},{0,-1}};
  public static int[][] map;
  public static int getAnswer(int[][] map){
    int cnt = 0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(map[i][j] == 0){
          cnt++;
        }
      }
    }
    return cnt;
  }
  public static int[][] fillMap(ArrayList<CCTV> cctvs){
    int[][] newMap = new int[n][m];
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        newMap[i][j] = map[i][j];
      }
    }
    for(int i=0; i<cctvs.size(); i++){
      CCTV curr = cctvs.get(i);
      int currX = curr.x;
      int currY = curr.y;
      for(int j=0; j<curr.directions.size(); j++){
        int dir = curr.directions.get(j);
        int nx = currX + vectors[dir][0];
        int ny = currY + vectors[dir][1];
        while(true){
          if(nx < 0 || nx >= n || ny < 0 || ny >= m)
            break;
          if(newMap[nx][ny] == 6)
            break;
          if(newMap[nx][ny] == 0){
            newMap[nx][ny] = -1;
          }
          nx += vectors[dir][0];
          ny += vectors[dir][1];
        }
      }
    }
    return newMap;
  }
  public static void DFS(ArrayList<CCTV> cctvs, int depth){
    if(depth == cctvs.size()){
      int[][] newMap = fillMap(cctvs);
      min = Math.min(min, getAnswer(newMap));
      return;
    }
    DFS(cctvs, depth+1);
    CCTV cctv = cctvs.get(depth);
    int num = cctv.n;
    if(num == 2){
      cctv.turn();
      DFS(cctvs, depth+1); 
    }
    else if(num == 1 || num == 3 || num == 4){
      for(int i=0; i<3; i++){
        cctv.turn();
        DFS(cctvs, depth+1);
      }
    }
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    ArrayList<CCTV> cctvs = new ArrayList<>();
    map = new int[n][m];
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        if(1 <= map[i][j] && map[i][j] <= 5){
          cctvs.add(new CCTV(i, j, map[i][j]));
        }
      }
    }
    
    DFS(cctvs, 0);
    System.out.println(min);
  }
}
