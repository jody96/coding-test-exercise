import java.util.*;
class Main {
  public static int n, k, l;
  public static int[][] board;
  public static int[][] snake;
  public static int hDir = 1;
  public static int tDir = 1;
  public static int[] head = {1,1};
  public static int[] tail = {1,1};
  public static int[][] vector = {{-1,0}, {0,1}, {1,0}, {0,-1}};
  public static Map<Integer, String> map = new HashMap<>();
  public static int time = 0;
  public static boolean move(){
    for(int i=0; i<2; i++){
      head[i] += vector[hDir][i];
    }
    if(head[0] <= 0 || head[0] > n || head[1] <= 0 || head[1] > n)
      return false;
    if(snake[head[0]][head[1]] == 1)
      return false;
    snake[head[0]][head[1]] = 1;
    if(board[head[0]][head[1]] == 1){
      board[head[0]][head[1]] = 0;
    } else{
      if(snake[tail[0]+vector[tDir][0]][tail[1]+vector[tDir][1]] == 0){
          for(int j=0; j<4; j++){
            if(snake[tail[0]+vector[j][0]][tail[1]+vector[j][1]] == 1){
              tDir = j;
              break;
            }
          }
      }
      snake[tail[0]][tail[1]] = 0;
      for(int i=0; i<2; i++){  
        tail[i] += vector[tDir][i];
      }
    }
    return true;
  }
  public static void turn(String turnDir){
    if(turnDir.equals("L")){
      hDir--;
      if(hDir <0)
        hDir = 3;
    }else{
      hDir++;
      if(hDir > 3)
        hDir = 0;
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    board = new int[n+1][n+1];
    snake = new int[n+1][n+1];
    snake[1][1] = 1;
    k = sc.nextInt();
    for(int i=0; i<k; i++){
      int r = sc.nextInt();
      int c = sc.nextInt();
      board[r][c] = 1;
    }
    l = sc.nextInt();
    
    for(int i=0; i<l; i++){
      int key = sc.nextInt();
      String value = sc.next();
      map.put(key, value);
    }

    while(true){
      time++;
      if(!move())
        break;
      if(map.containsKey(time)){
        turn(map.get(time));
      }
    }
    System.out.println(time);
  }
}
