import java.util.*;

class Main {
  public static int[] parent = new int[100001];
  public static int getParent(int x){
    if(x == parent[x])
      return x;
    return parent[x] = getParent(parent[x]);
  }

  public static void union(int a, int b){
    int aParent = getParent(a);
    int bParent = getParent(b);

    if(aParent < bParent){
      parent[b] = a;
    } else{
      parent[a] = b;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int m = sc.nextInt();
    
    for(int i=1; i<=n; i++){
      parent[i] = i;
    }
    ArrayList<String> answer = new ArrayList<>();
    for(int i=0; i<m; i++){
      int operation = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      if(operation == 0){
        union(a, b);
      } else{
        if(getParent(a) == getParent(b)){
          answer.add("YES");
        } else{
          answer.add("NO");
        }
      }
    }
    for(int i=0; i<answer.size(); i++){
      System.out.println(answer.get(i));
    }
  }
}
