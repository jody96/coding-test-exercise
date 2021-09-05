import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int ans = 0;
    while(n != 1){
      if(n % k == 0){
        n /= k;
      } else{
        n -= 1;
      }
      ans++;
    }
    
    System.out.println(ans);
  }
}
