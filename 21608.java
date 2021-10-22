import java.util.*;
import java.io.*;
class Place implements Comparable<Place>{
  int x;
  int y;
  int adjFriends;
  int adjEmpty;

  public Place(int x, int y, int f, int e){
    this.x = x;
    this.y = y;
    this.adjFriends = f;
    this.adjEmpty = e;
  }
  @Override
  public int compareTo(Place other){
    if(this.adjFriends == other.adjFriends){
      if(this.adjEmpty == other.adjEmpty){
        if(this.x == other.x){
          return this.y - other.y;
        }
        return this.x - other.x;
      }
      return other.adjEmpty - this.adjEmpty;
    }
    return other.adjFriends - this.adjFriends;
  }
}
class Main {
  public static int n;
  public static int graph[][] = new int[21][21];
  public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
  public static ArrayList<Integer> order = new ArrayList<>();
  public static int[][] vectors = {{-1,0},{0,1},{1,0},{0,-1}};
  public static int happy = 0;
  public static int getAdjacentFriends(int i, int j, int id){
    ArrayList<Integer> bestFriends = map.get(id);
    int friends = 0;
    for(int d=0; d<4; d++){
      int ni = i + vectors[d][0];
      int nj = j + vectors[d][1];

      if(ni < 0 || ni >= n || nj < 0 || nj >= n)
        continue;
      for(int k=0; k<4; k++){
        if(graph[ni][nj] == bestFriends.get(k))
          friends++;
        }
    }
    return friends;
  }
  public static int getScore(int friends){
    switch(friends){
      case 0:
        return 0;
      case 1:
        return 1;
      case 2:
        return 10;
      case 3:
        return 100;
      case 4:
        return 1000;
    }
    return -1;
  }
  public static void getHappy(){
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        int numOfFriends = getAdjacentFriends(i, j, graph[i][j]);
        happy += getScore(numOfFriends);
      }
    }
  }
  public static void check(int id){
    PriorityQueue<Place> pq = new PriorityQueue<>();
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(graph[i][j] != 0)
          continue;
        ArrayList<Integer> bestFriends = map.get(id);
        int empty = 0;
        int friends = 0;
        for(int d=0; d<4; d++){
          int ni = i + vectors[d][0];
          int nj = j + vectors[d][1];

          if(ni < 0 || ni >= n || nj < 0 || nj >= n)
            continue;
          if(graph[ni][nj] == 0){
            empty++;
            continue;
          }
          for(int k=0; k<4; k++){
            if(graph[ni][nj] == bestFriends.get(k))
              friends++;
          }
        }
        pq.add(new Place(i, j, friends, empty));
      }
    }
    Place selected = pq.poll();
    graph[selected.x][selected.y] = id;
  }
  public static void process(){
    for(int i=0; i<order.size(); i++){
      int id = order.get(i);
      check(id);
    }
    getHappy();
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int N = n*n;
    for(int i=0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      ArrayList<Integer> friends = new ArrayList<>();
      for(int j=0; j<4; j++){
        friends.add(Integer.parseInt(st.nextToken()));
      }
      order.add(id);
      map.put(id, friends);
    }
    process();
    System.out.println(happy);
  }
}
