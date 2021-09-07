import java.util.*;
class Main {
  public static int n;
  public static int[] weight;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    int m = sc.nextInt();
    weight = new int[m+1];
    
    for(int i=0; i<n; i++){
      weight[sc.nextInt()]++;
    }
    int answer = n*(n-1)/2;
    for(int i=1; i<=m; i++){
      int w = weight[i];
      if(w >= 2){
        answer -= (w*(w-1)/2);
      }
    }
    System.out.println(answer);
  }
}
