import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = 1;
    int y = 1;
    st = new StringTokenizer(br.readLine());

    while(st.hasMoreTokens()){
      char dir = st.nextToken().charAt(0);
      int nx = x;
      int ny = y;
      switch(dir){
        case 'R': 
          ny += 1;
          break;
        case 'L': 
          ny -= 1;
          break;
        case 'U': 
          nx -= 1;
          break;
        case 'D': 
          nx += 1;
          break;
      }
      if(nx < 1 || nx > n || ny < 1 || ny > n)
        continue;
      else{
        x = nx;
        y = ny;
      }
    }
    System.out.println(x+ " " + y);
  }
}
