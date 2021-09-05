//dynamic programming
import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] d0 = new int[n];
    int[] d1 = new int[n];
    d0[0] = arr[0];
    d1[1] = arr[1];
    for(int i=2; i<n; i++){
      d0[i] = Math.max(d0[i-2] + arr[i], d0[i-1]);
      d1[i] = Math.max(d1[i-2] + arr[i], d1[i-1]);
    }

    System.out.println(Math.max(d0[n-1], d1[n-1]));
  }
}
