import java.util.*;
class Main {
  public static int n, result;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0; i<n; i++){
      pq.offer(sc.nextInt());
    }

    while(pq.size() != 1){
      int one = pq.poll();
      int two = pq.poll();
      int summary = one + two;
      result += summary;
      pq.offer(summary);    
    }
    System.out.println(result);
  }
}
