import java.util.*;
class Main {
  public static int n;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[] arr = new int[n];

    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    } 
    
    Arrays.sort(arr);
    int answer = 1;
    for(int i=0; i<n; i++){
      if(arr[i] > answer){
        break;
      }
      answer += arr[i];
    }
    System.out.println(answer);
  }
}
