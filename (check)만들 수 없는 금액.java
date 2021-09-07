import java.util.*;
class Main {
  public static int n;
  public static ArrayList<Integer> arrayList = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    
    for(int i=0; i<n; i++){
      arrayList.add(sc.nextInt());
    }

    Collections.sort(arrayList);

    int target = 1;
    for(int i=0; i<n; i++){
      if(target < arrayList.get(i)) break;
      target += arrayList.get(i);
    }

    System.out.println(target);
  }
  
}
