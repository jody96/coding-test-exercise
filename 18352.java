import java.util.*;
class Main {
  public static int n, m, k, x;
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    x = sc.nextInt();
    for(int i=0; i<=n; i++){
      graph.add(new ArrayList<Integer>());
    }
    for(int i=0; i<m; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph.get(a).add(b);
    }

    int[] minArr = new int[n+1];
    Arrays.fill(minArr, (int)1e9);
    minArr[x] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(x);
    
    while(!queue.isEmpty()){
      int curr = queue.poll();

      for(int i=0; i<graph.get(curr).size(); i++){
        int next = graph.get(curr).get(i);
        if(minArr[next] == (int)1e9){
          minArr[next] = Math.min(minArr[next], minArr[curr] + 1);
          queue.add(next);
        }
      }
    }
    ArrayList<Integer> answer = new ArrayList<>();
    for(int i=1; i<=n; i++){
      if(minArr[i] == k){
        answer.add(i);
      }
    }
    if(answer.size() == 0){
      System.out.println(-1);
      return;
    }
    Collections.sort(answer);
    for(int i=0; i<answer.size(); i++)
      System.out.println(answer.get(i));
  }
}
