import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    ArrayList<Integer> arr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++){
      arr.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(arr, Collections.reverseOrder());
    int answer = 0;
    int len = arr.size(); 
    for(int i=0; i<M; i++){
      int idx = (i % len) /K;
      answer += arr.get(idx);
    }
    System.out.println(answer);
  }
}
