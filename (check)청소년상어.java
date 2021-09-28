import java.util.*;
import java.io.*;

class Shark {
  int x, y, dir, eatSum;
  Shark() {}
  Shark(int x, int y, int dir, int eatSum){
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.eatSum = eatSum;
  }
}
class Fish {
  int x, y, id, dir;
  boolean isAlive = true;
  Fish() {}
  Fish(int x, int y, int id, int dir, boolean isAlive){
    this.x = x;
    this.y = y;
    this.id = id;
    this.dir = dir;
    this.isAlive = isAlive;
  }
}

class Main {
  public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
  public static int maxSum = 0;
  public static int[][] copyArr(int[][] arr){
    int[][] temp = new int[4][4];

    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++){
        temp[i][j] = arr[i][j];
      }
    }
    return temp;
  }
  public static List<Fish> copyFishes(List<Fish> fishes){
    List<Fish> temp = new ArrayList<>();
    for(int i=0; i<fishes.size(); i++){
      Fish now = fishes.get(i);
      temp.add(new Fish(now.x, now.y, now.id, now.dir, now.isAlive));
    }
    return temp;
  }
  public static void moveFish(Fish fish, int[][] arr, List<Fish> fishes){
    if(fish.isAlive == false) return;

    for(int i=0; i<8; i++){
      int nextDir = (fish.dir + i) % 8;
      int nx = fish.x + dx[nextDir];
      int ny = fish.y + dy[nextDir];
      
      if(0<=nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > -1){
        arr[fish.x][fish.y] = 0;

        if(arr[nx][ny] == 0){
          fish.x = nx;
          fish.y = ny;
        } else {
          Fish temp = fishes.get(arr[nx][ny] - 1);
          temp.x = fish.x;
          temp.y = fish.y;
          arr[fish.x][fish.y] = temp.id;

          fish.x = nx;
          fish.y = ny;
        }

        arr[nx][ny] = fish.id;
        fish.dir = nextDir;
        return;
      }
    }
  }
  public static void dfs(int[][] arr, Shark shark, List<Fish> fishes){
    if(maxSum < shark.eatSum){
      maxSum = shark.eatSum;
    }

    for(int i=0; i<fishes.size(); i++){
      moveFish(fishes.get(i), arr, fishes);
    }

    for(int dist = 1; dist < 4; dist++){
      int nx = shark.x + dx[shark.dir] * dist;
      int ny = shark.y + dy[shark.dir] * dist;

      if(0 <= nx && nx < 4 && 0 <= ny && ny < 4 && arr[nx][ny] > 0){
        int[][] arrCopies = copyArr(arr);
        List<Fish> fishCopies = copyFishes(fishes);
        
        arrCopies[shark.x][shark.y] = 0;
        Fish f = fishCopies.get(arr[nx][ny]-1);
        Shark newShark = new Shark(f.x, f.y, f.dir, shark.eatSum + f.id);
        f.isAlive =false;
        arrCopies[f.x][f.y] = -1;

        dfs(arrCopies, newShark, fishCopies);
      }
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[][] arr = new int[4][4];
    List<Fish> fishes = new ArrayList<>();

    for(int i=0; i<4; i++){
      st = new StringTokenizer(br.readLine());

      for(int j=0; j<4; j++){
        Fish f = new Fish();
        f.id = Integer.parseInt(st.nextToken());
        f.dir = Integer.parseInt(st.nextToken()) - 1;
        f.x = i;
        f.y = j;

        fishes.add(f);
        arr[i][j] = f.id;
      }
    }

    Collections.sort(fishes, new Comparator<Fish>(){
      @Override
      public int compare(Fish o1, Fish o2){
        return o1.id - o2.id;
      }
    });

    Fish f = fishes.get(arr[0][0]-1);
    Shark shark = new Shark(0,0,f.dir, f.id);
    f.isAlive = false;
    arr[0][0] = -1;

    dfs(arr, shark, fishes);
    System.out.println(maxSum);
  }
}
