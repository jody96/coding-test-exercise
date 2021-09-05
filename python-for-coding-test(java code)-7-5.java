import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    ArrayList<String> answer = new ArrayList<>();
    ArrayList<Integer> arr1 = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      arr1.add(Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());
    ArrayList<Integer> arr2 = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<m; i++){
      arr2.add(Integer.parseInt(st.nextToken()));
    }

    for(int i=0; i<m; i++){
      String ans = "";
      if(binarySearch(arr2.get(i), arr1)){
        ans = "yes";
      } else{
        ans = "no";
      }
      answer.add(ans);
    }

    for(int i=0; i<answer.size(); i++){
      System.out.print(answer.get(i) + " ");
    }
  }

  public static boolean binarySearch(int target, ArrayList<Integer> arr){
    int start = 0;
    int end = arr.size()-1;
    int mid = 0;
    while(start <= end){
      mid = (start + end) / 2;
      
      int comp = arr.get(mid);
      if(comp == target)
        return true;
      else if(comp < target){
        start = mid + 1;
      } else{
        end = mid - 1;
      }
    }
    return false;
  }
}
