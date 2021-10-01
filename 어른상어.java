import java.util.*;
class Shark {
  int x,y,id,dir;
  int[][] priority = new int[5][5];

  public Shark(){};
  public int getNextDir(Set<Integer> set){
    for(int i=1; i<=4; i++){
      if(set.contains(priority[dir][i])){
        return priority[dir][i];
      }
    }
    return 0;
  }
}
class Main {
  public static int time = 0;
  public static int[][] arr = new int[21][21];
  public static int[][] smellOwner = new int[21][21];
  public static int[][] leftTime = new int[21][21];
  public static Map<Integer, Shark> sharks = new HashMap<>();
  public static int n,m,k;
  public static int[][] vector = {{-1,0},{1,0},{0,-1},{0,1}};
  public static void sharkMove(){
    ArrayList<Integer> willRemove = new ArrayList<>();
    for(Integer i : sharks.keySet()){
      Shark s = sharks.get(i);
      Set<Integer> noSmell = new HashSet<>();
      Set<Integer> mySmell = new HashSet<>();
      for(int j=0; j<4; j++){
        int nr = s.x + vector[j][0];
        int nc = s.y + vector[j][1];

        if(nr >= n || nr < 0 || nc >= n || nc < 0)
          continue;
        if(smellOwner[nr][nc] == 0){
          noSmell.add(j+1);
        }else if(smellOwner[nr][nc] == s.id){
          mySmell.add(j+1);
        }
      }
      int nextDir = s.getNextDir(noSmell);
      if(nextDir == 0){
        nextDir = s.getNextDir(mySmell);
      }

      int nx = s.x + vector[nextDir-1][0];
      int ny = s.y + vector[nextDir-1][1];
      
      arr[s.x][s.y] = 0;
      if(arr[nx][ny] == 0 || s.id < arr[nx][ny]){
        arr[nx][ny] = s.id;
        s.x = nx;
        s.y = ny;
        s.dir = nextDir;
      } else{
        willRemove.add(s.id);
      }
    }

    for(int i=0; i<willRemove.size(); i++){
      sharks.remove(willRemove.get(i));
    }
  }
  public static void decreaseSmell(){
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(leftTime[i][j] > 0){
          leftTime[i][j]--;
          if(leftTime[i][j] == 0){
            smellOwner[i][j] = 0;
          }
        }
      }
    }
    return;
  }
  public static void spreadSmell(){
    for(Integer i : sharks.keySet()){
      Shark s = sharks.get(i);
      smellOwner[s.x][s.y] = s.id;
      leftTime[s.x][s.y] = k;
    }
    return;
  }
  public static int solution(){
    while(time++ < 1000){
      sharkMove();
      decreaseSmell();
      spreadSmell();
      if(sharks.size() == 1){
        return time;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        int input = sc.nextInt();
        if(input > 0){
          Shark shark = new Shark();
          shark.x = i;
          shark.y = j;
          shark.id = input;
          sharks.put(input, shark);
          arr[i][j] = input;
          smellOwner[i][j] = input;
          leftTime[i][j] = k;
        }
      }
    }
    for(int i=0; i<m; i++){
      Shark s = sharks.get(i+1);
      s.dir = sc.nextInt();
    }
    
    for(int i=0; i<m; i++){
      Shark s = sharks.get(i+1);
      for(int j=1; j<=4; j++){
        for(int z=1; z<=4; z++){
          s.priority[j][z] = sc.nextInt();
        }
      }
    }
    int answer = solution();
    System.out.println(answer);
  }
}
