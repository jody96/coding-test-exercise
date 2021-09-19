import java.util.*;

class Main {
  public static int n, m, k, x;
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  public static int[] d = new int[300001];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    x = sc.nextInt();

    for(int i=0; i<=n; i++){
      graph.add(new ArrayList<Integer>());
      d[i]= -1;
    }

    for(int i=0; i<m; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      graph.get(a).add(b);
    }

    d[x] = 0;

    Queue<Integer> q = new LinkedList<Integer>();
    q.offer(x);
    while(!q.isEmpty()){
      int now = q.poll();
      for(int i=0; i<graph.get(now).size(); i++){
        int nextNode = graph.get(now).get(i);
        if(d[nextNode] == -1){
          d[nextNode] = d[now] + 1;
          q.offer(nextNode);
        }
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    boolean check =false;
    for(int i=1; i<=n; i++){
      if(d[i] == k){
        result.add(i);
        check = true;
      }
    }
    if(!check) System.out.println(-1);
    Collections.sort(result);
    for(int i=0; i<result.size(); i++)
      System.out.println(result.get(i));
  }
}
