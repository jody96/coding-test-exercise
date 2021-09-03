//출처: 이것이 취업을 위한 코딩테스트다. 저자: 나동빈
import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
  int index;
  int distance;

  public Node(int index, int distance){
    this.index = index;
    this.distance = distance;
  }

  public int getIndex(){
    return this.index;
  }

  public int getDistance(){
    return this.distance;
  }

  @Override
  public int compareTo(Node other){
    if(other.distance > this.distance){
      return -1;
    } 
    return 1;
  }
}
class Main {
  public static int n;
  public static int m;
  public static int c;
  public static int[] d = new int[30001];
  public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  public static final int INF = (int)1e9;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    for(int i=0; i<=n; i++){
      graph.add(new ArrayList<Node>());
    }
    
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, d));
    }
    Arrays.fill(d, INF);
    dijkstra(c);
    int count = -1;
    int max = Integer.MIN_VALUE;
    for(int i=1; i<=n; i++){
      if(d[i] != INF){
        count++;
        max = Math.max(d[i], max);
      }
    }
    System.out.println(count + " " + max);
  }
  static public void dijkstra(int start){
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    pq.offer(new Node(start, 0));
    d[start] = 0;

    while(!pq.isEmpty()){
      Node newNode = pq.poll();
      int now = newNode.getIndex();
      int dist = newNode.getDistance();
      
      if(d[now] < dist)
        continue;
      for(int i=0; i<graph.get(now).size(); i++){
        int cost = graph.get(now).get(i).getDistance() + d[now];
        if(cost < d[graph.get(now).get(i).getIndex()]){
          d[graph.get(now).get(i).getIndex()] = cost;
          pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
        }
      }
    }
  }
}
