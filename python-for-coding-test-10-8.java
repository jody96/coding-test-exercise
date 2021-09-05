import java.util.*;

class Node implements Comparable<Node>{
  private int distance;
  private int nodeA;
  private int nodeB;

  public Node(int nodeA, int nodeB, int distance){
    this.distance = distance;
    this.nodeA = nodeA;
    this.nodeB = nodeB;
  }

  public int getDistance(){
    return this.distance;
  }

  public int getNodeA(){
    return this.nodeA;
  }

  public int getNodeB(){
    return this.nodeB;
  }

  @Override
  public int compareTo(Node other){
    if(other.distance > this.distance){
      return -1;
    } else{
      return 1;
    }
  }
}
class Main {
  public static int n, m;
  public static int[] parent = new int[100001];
  public static int getParent(int x){
    if(x == parent[x]){
      return x;
    }
    return parent[x] = getParent(parent[x]);
  }
  
  public static void union(int a, int b){
    a = getParent(a);
    b = getParent(b);

    if(a < b){
      parent[b] = a;
    } else{
      parent[a] = b;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    n = sc.nextInt();
    m = sc.nextInt();
  
    PriorityQueue<Node> queue = new PriorityQueue<>();

    for(int i=0; i<=n; i++){
      parent[i] = i;
    }
    for(int i=0; i<m; i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      queue.offer(new Node(a, b, c));
    }
    int result = 0;
    ArrayList<Integer> arr = new ArrayList<>();

    for(int i=0; i<m; i++){
      Node now = queue.poll();
      int from = now.getNodeA();
      int to = now.getNodeB();
      int cost = now.getDistance();

      if(getParent(from) == getParent(to)){
        continue;
      }
      union(from, to);
      arr.add(cost);
    }
    for(int i=0; i<arr.size()-1; i++){
      result += arr.get(i);
    }
    System.out.println(result);
  }
}
