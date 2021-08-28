import java.util.*;
import java.io.*;

class Main {
  public static int n;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    ArrayList<Integer> arr1 = getArr(br.readLine());
    ArrayList<Integer> arr2 = getArr(br.readLine());
    
    Collections.sort(arr1);
    Collections.sort(arr2, Collections.reverseOrder());

    for(int i=0; i<k; i++){
      arr1.remove(0);
      arr1.add(arr2.get(i));
    }
    int sum = 0;
    for(int i=0; i<arr1.size(); i++){
      sum += arr1.get(i);
    }

    System.out.println(sum);
  }
  public static ArrayList<Integer> getArr(String str){
    ArrayList<Integer> arr = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(str);
    
    for(int i=0; i<n; i++){
      arr.add(Integer.parseInt(st.nextToken()));
    }

    return arr;
  }
}
