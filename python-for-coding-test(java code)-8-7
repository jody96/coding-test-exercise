//dynamic programming
import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    
    int answer = 1;
    int[] arr = new int[n+1];
    arr[1] = 1;
    arr[2] = 3;

    for(int i=3; i<=n; i++){
      arr[i] = (arr[i-1] + arr[i-2] * 2) % 796796; 
    }
    answer = arr[n];
    System.out.println(answer);
  }
}
