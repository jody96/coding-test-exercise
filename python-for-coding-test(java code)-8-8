import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] inputs = new int[n];

    for(int i=0; i<n; i++){
      inputs[i] = Integer.parseInt(br.readLine());
    }

    int[] arr = new int[m+1];
    Arrays.fill(arr, 10001);
    arr[0] = 0;

    for(int i=0; i<n; i++){
      for(int j=inputs[i]; j<=m; j++){
        if(arr[j-inputs[i]] != 10001){
          arr[j] = Math.min(arr[j], arr[j-inputs[i]]+1);
        }
      }
    }

    if(arr[m] == 10001){
      System.out.println(-1);
    } else{
      System.out.println(arr[m]);
    }
  }
}
