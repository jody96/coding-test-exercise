import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<Integer> arr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      arr.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(arr);
    int answer = bs(arr, m);

    System.out.println(answer);
  }
  public static int bs(ArrayList<Integer> arr, int target){
    int start = 0;
    int end = arr.get(arr.size()-1);
    int mid = 0;
    int ret = 0;
    while(start<=end){
      mid = (start + end) / 2;
      int len = 0;
      for(int i=0; i<arr.size(); i++){
        int com = arr.get(i);
        if(mid < com)
          len += (com - mid);
      }

      if(target < len){
        start = mid + 1;
      } else{
        ret = mid;
        end = mid - 1;
      }
    }
    return ret;
  }

}
