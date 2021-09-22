import java.util.*;
class Main {
  public static int n;
  public static ArrayList<Integer> arr = new ArrayList<>();
  public static int[] operators = new int[4];
  public static int min = (int)1e9;
  public static int max = -(int)1e9;
  public static int operation(int operator, int i, int j){
    int ret = 0;
    switch(operator){
      case 0:
        ret = i + j;
        break;
      case 1:
        ret = i - j;
        break;
      case 2:
        ret = i * j;
        break;
      case 3:
        if(i < 0){
          ret = -(-i / j);
        }
        ret = i / j;
        break;
    }
    return ret;
  }
  public static void DFS(int num, int nextIdx){
    if(nextIdx == arr.size()){
      min = Math.min(num, min);
      max = Math.max(num, max);
      return;
    }
    int result = num;
    for(int i=0; i<4; i++){
      if(operators[i] != 0){
        result = operation(i, num, arr.get(nextIdx));
        operators[i]--;
        DFS(result, nextIdx+1);
        operators[i]++;
      }
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    for(int i=0; i<n; i++)
      arr.add(sc.nextInt());
    
    for(int i=0; i<4; i++){
      operators[i] = sc.nextInt();
    }
    DFS(arr.get(0), 1);
    System.out.println(max);
    System.out.println(min);
  }
}
