// dynamic programming
import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int x = Integer.parseInt(br.readLine());
    
    int[] arr = new int[30000];
    int answer = 0;
    for(int i=2; i<=x; i++){
        arr[i] = arr[i-1] + 1;
        if(i % 5 == 0){
          arr[i] = Math.min(arr[i], arr[i/5]+1);
        } 
        if(i % 3 == 0){
          arr[i] = Math.min(arr[i], arr[i/3]+1);
        }
        if(i % 2 == 0){
          arr[i] = Math.min(arr[i], arr[i/2]+1);
        }
    }

    System.out.println(arr[x]);
  }
}
