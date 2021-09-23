import java.util.*;
import java.io.*;
class Person{
  private int x;
  private int y;

  Person(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }
}
class Main {
  public static int n;
  public static char[][] graph = new char[6][6];
  public static char[][] modGraph = new char[6][6];
  public static ArrayList<Person> teachers = new ArrayList<>();
  public static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}};
  public static boolean answer = false;
  public static boolean teacherMove(Person teacher){
    int x = teacher.getX();
    int y = teacher.getY();

    for(int i=x-1; i >= 0; i--){
      if(graph[i][y] == 'O')
        break;
      if(graph[i][y] == 'S')
        return false;
    }
    for(int i=y+1; i < n; i++){
      if(graph[x][i] == 'O')
        break;
      if(graph[x][i] == 'S')
        return false;
    }
    for(int i=x+1; i < n; i++){
      if(graph[i][y] == 'O')
        break;
      if(graph[i][y] == 'S')
        return false;
    }
    for(int i=y-1; i >= 0; i--){
      if(graph[x][i] == 'O')
        break;
      if(graph[x][i] == 'S')
        return false;
    }
    return true;
  }
  public static boolean checkMonitor(){
    for(int i=0; i<teachers.size(); i++){
      if(!teacherMove(teachers.get(i))){
        return false;
      }
    }
    return true;
  }
  public static void DFS(int depth){
    if(depth == 3){
      if(checkMonitor()){
        answer = true;
      }
      return;
    }
    
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(graph[i][j] == 'X'){
          graph[i][j] = 'O';
          DFS(depth+1);
          graph[i][j] = 'X';
        }
      }
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    n = Integer.parseInt(br.readLine());
    for(int i=0; i<n; i++){
      String str = br.readLine();
      StringTokenizer st = new StringTokenizer(str);
      
      for(int j=0; j<n; j++){
        graph[i][j] = st.nextToken().charAt(0);
        if(graph[i][j] == 'T'){
          teachers.add(new Person(i, j));
        }
      }
    }

    DFS(0);
    if(answer)
      System.out.println("YES");
    else
     System.out.println("NO");
  }
}
