출처: https://so-cute-danu-dev.tistory.com/95
import java.util.*;
import java.io.*;
class Main {
  public static int[][] map;
  public static int N, Q;
  public static int[] dy = {-1,1,0,0};
  public static int[] dx = {0,0,-1,1};
  public static void rotate(int l, int n, int y, int x){
    if(n == l){
      int[][] init_map = new int[n][n];
      int idx_y = 0;
      for(int i=y; i<n+y; i++){
        int idx_x = 0;
        for(int j=x; j<n+x; j++){
          init_map[idx_y][idx_x++] = map[i][j];
        }
        idx_y++;
      }
      idx_y = 0;
      for(int i=y; i<n+y; i++){
        int idx_x = 0;
        for(int j=x; j<n+x; j++){
          map[i][j] = init_map[n-1-idx_x++][idx_y];
        }
        idx_y++;
      }
      return;
    }

    rotate(l, n/2, y, x);
    rotate(l, n/2, y, x + n/2);
    rotate(l, n/2, y+n/2, x);
    rotate(l, n/2, y+n/2, x+n/2);
  }
  public static void meltice(){
    ArrayList<int[]> list = new ArrayList<>();
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(map[i][j] == 0)
          continue;
        int ice_cnt = 4;
        for(int d=0; d<4; d++){
          int next_y = i + dy[d];
          int next_x = j + dx[d];
          if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= N){
            ice_cnt--;
            continue;
          }
          if(map[next_y][next_x] == 0){
            ice_cnt--;
            continue;
          }
        }
        if(ice_cnt <= 2){
          list.add(new int[]{i, j});
        }
      }
    }

    for(int[] position: list){
      int y = position[0];
      int x = position[1];
      if(map[y][x] > 0)
        map[y][x]--;
    }
  }
  public static void process(int[] l){
    for(int i=0; i<Q; i++){
      int level = l[i];
      rotate(level, N, 0, 0);
      meltice();
    }
  }
  public static int[] findLump(){
    boolean[][] visited = new boolean[N][N];
    int sum = 0;
    int lump = 0;
    int max_lump = 0;

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        sum += map[i][j];
        if(map[i][j] == 0) continue;
        if(visited[i][j]) continue;
        Queue<int[]> ice_queue = new LinkedList<int[]>();
        ice_queue.offer(new int[]{i, j});
        visited[i][j] = true;
        lump = 0;

        while(!ice_queue.isEmpty()){
          int[] cur_ice = ice_queue.poll();
          int y = cur_ice[0];
          int x = cur_ice[1];
          lump++;

          for(int d=0; d<4; d++){
            int next_y = y + dy[d];
            int next_x = x + dx[d];

            if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= N)
              continue;
            if(map[next_y][next_x] == 0)
              continue;
            if(visited[next_y][next_x])
              continue;
            ice_queue. offer(new int[]{next_y, next_x});
            visited[next_y][next_x] = true;
          }
        }
        max_lump = max_lump > lump ? max_lump : lump;
      }
    }
    int[] res = {sum, max_lump};
    return res;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
    Q = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[] L = new int[Q];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<Q; i++){
      L[i] = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
    }

    process(L);

    int[] res = findLump();    
    System.out.println(res[0]);
    System.out.println(res[1]);
  }
}
