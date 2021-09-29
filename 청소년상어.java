import java.util.*;
class Fish implements Comparable<Fish>{
  int x,y,dir,id;
  boolean isAlive = true;
  
  public Fish() {}

  public Fish(int x, int y, int dir, int id){
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.id = id;
  }

  @Override
  public int compareTo(Fish other){
    return this.id - other.id;
  }
}
class Shark {
  int x, y, dir, eatSum;

  public Shark() {}
  
  public Shark(int x, int y, int dir, int eatSum){
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.eatSum = eatSum;
  }
}

class Main {
  public static int[][] vector = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
  public static int max = 0;
  public static ArrayList<Fish> fishListCopy(List<Fish> fishList){
    ArrayList<Fish> copied = new ArrayList<>();
    for(int i=0; i<fishList.size(); i++){
      Fish now = fishList.get(i);
      Fish newFish = new Fish(now.x, now.y, now.dir, now.id);
      newFish.isAlive = now.isAlive;
      copied.add(newFish);
    }
    return copied;
  }
  public static int[][] arrayCopy(int[][] graph){
    int[][] copied = new int[4][4];
    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++){
        copied[i][j] = graph[i][j];
      }
    }
    return copied;
  }
  public static void fishMove(Fish fish, int[][] graph, ArrayList<Fish> fishList){
    int x = fish.x;
    int y = fish.y;
    int dir = fish.dir;
    for(int i=0; i<8; i++){
      int direction = (dir + i) % 8;
      int nx = x + vector[direction][0];
      int ny = y + vector[direction][1];
      if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
        continue;
      if(graph[nx][ny] < 0)
        continue;
      if(graph[nx][ny] == 0){
        graph[nx][ny] = graph[x][y];
        fish.x = nx;
        fish.y = ny;
        graph[x][y] = 0;
      } else{
        Fish next = fishList.get(graph[nx][ny]-1);
        graph[nx][ny] = graph[x][y];
        fish.x = nx;
        fish.y = ny;
        next.x = x;
        next.y = y;
        graph[x][y] = next.id; 
      }
      fish.dir = direction;
      break;
    }
  }

  public static void dfs(int[][] graph, ArrayList<Fish> fishList, Shark shark){

    max = Math.max(max, shark.eatSum);
    for(int i=0; i<fishList.size(); i++){
      Fish curr = fishList.get(i);
      if(!curr.isAlive)
        continue;
      fishMove(curr, graph, fishList);
    }
    int sx = shark.x;
    int sy = shark.y;
    int sd = shark.dir;
    
    for(int i=1; i<=4; i++){
      int nx = sx + vector[sd][0] * i;
      int ny = sy + vector[sd][1] * i;

      if(nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
        continue;
      if(graph[nx][ny] <= 0)
        continue;
      
      ArrayList<Fish> newFishList = fishListCopy(fishList);
      int[][] newGraph = arrayCopy(graph);
      newGraph[sx][sy] = 0;
      Fish eaten = newFishList.get(newGraph[nx][ny]-1);
      eaten.isAlive = false;
      Shark newShark = new Shark(eaten.x, eaten.y, eaten.dir, eaten.id + shark.eatSum);
      newGraph[nx][ny] = -1;
      
      dfs(newGraph, newFishList, newShark);
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] graph = new int[4][4];
    ArrayList<Fish> fishList = new ArrayList<>();
    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++){
        Fish fish = new Fish();
        fish.x = i;
        fish.y = j;
        fish.id = sc.nextInt();
        fish.dir = sc.nextInt()-1;
        graph[i][j] = fish.id;
        fishList.add(fish);
      }
    }
    Collections.sort(fishList);
    Fish first = fishList.get(graph[0][0]-1);
    first.isAlive = false;
    graph[0][0] = -1;
    dfs(graph, fishList, new Shark(0,0,first.dir, first.id));
    System.out.println(max);
  }
}
