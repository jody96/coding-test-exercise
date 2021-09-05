import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());

    int h = 0;
    int m = 0;
    int s = 0;
    int ans = 0;
    for(h =0; h < n+1; h++){
      for(m=0; m<60; m++){
        for(s=0; s<60; s++){
          if(h % 10 == 3 || h / 10 == 3 ||
            m  % 10 == 3 || m / 10 == 3 ||
            s % 10 == 3 || s / 10 == 3)
            ans++;
        }
      }
    }
    System.out.println(ans);
  }
}
