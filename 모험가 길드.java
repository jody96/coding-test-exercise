import java.util.*;
class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] people = new int[n+1];
    for(int i=1; i<=n; i++){
      people[i] = sc.nextInt();
    }
    Arrays.sort(people);

    int idx = 1;
    int answer = 0;
    
    while(idx <= n){
      int num = people[idx];
      if(people[idx + num - 1] > num)
        break;
      answer++;
      idx += num;
    }

    System.out.println(answer);
  }
}
