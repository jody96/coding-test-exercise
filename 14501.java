import java.util.*;
import java.io.*;
class Main {
  public static int n;
  public static int max = Integer.MIN_VALUE;
  public static ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
  public static void DFS(int day, int before, int profit){
    if(day > n+1){
      max = Math.max(max, profit-before);
      return;
    }
    int currProfit = inputs.get(day-1).get(1);
    DFS(day+1, 0, profit);
    DFS(day + inputs.get(day-1).get(0), currProfit, profit+currProfit);
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      
      inputs.add(new ArrayList<>());
      inputs.get(i).add(t);
      inputs.get(i).add(p);
    }
    inputs.add(new ArrayList<>());
    inputs.get(n).add(1);
    inputs.get(n).add(0);
    DFS(1, 0, 0);
    System.out.println(max);
  }
}
