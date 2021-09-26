import java.util.*;
class Main {
  public static int n;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();

    for(int i=0; i<n; i++){
      arr.add(sc.nextInt());
    }

    Collections.sort(arr);
    
    System.out.println(arr.get((arr.size()-1)/2));
  }
}
