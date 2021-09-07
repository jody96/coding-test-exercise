import java.util.*;

class Main {
  public static int n, k, l;
  public static int[][] graph = new int[101][101];
  public static int[][] snakeMap = new int[101][101];
  public static HashMap<Integer, Character> map = new HashMap<>();
  public static int hDir, hR, hC, tDir, tR, tC;
  public static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}};
  public static void turnLeft(){
    hDir -= 1;
    if(hDir < 0)
      hDir = 3;
  }
  public static void turnRight(){
    hDir += 1;
    if(hDir > 3)
      hDir = 0;
  }
  public static boolean moveForward(){
    int nr = hR + vector[hDir][0];
    int nc = hC + vector[hDir][1];

    if(nr <= 0 || nr > n || nc <= 0 || nc > n){
      return false;
    }
    if()
    
    
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int time = 0;
    n = sc.nextInt();
    m = sc.nextInt();
    map[1][1] = 1;
    hDir = 1;
    hR = 1;
    hC = 1;
    tDir = 1;
    tR = 1;
    tC = 1;
    for(int i=0; i<m; i++){
      int r = sc.nextInt();
      int c = sc.nextInt();
      graph[r][c] = 1;
    }
    l = sc.nextInt();
    for(int i=0; i<l; i++){
      int x = sc.nextInt();
      int c = sc.next().charAt(0);
      map.put(x,c);
    }
    while(true){
      if(map.containsKey(time)){
      char c = map.get(time);
      if(c == 'L'){
        hDir -= 1;
        if(hDir < 0)
          hDir = 3;
      } else{
        
      }
    }
      move(time);
      time++;
    }
    System.out.println(answer);
  }
}
