import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new HashMap<>();
    StringTokenizer st;
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int score = Integer.parseInt(st.nextToken());
      map.put(name, score);
    }

    Set set = map.keySet();
    ArrayList<String> array = new ArrayList<>(set);
    
    Collections.sort(array, new Comparator<String>(){
      @Override
      public int compare(String s1, String s2){
        return map.get(s1) - map.get(s2);
      }
    });

    for(int i=0; i<array.size(); i++){
      System.out.print(array.get(i) + " ");
    }
  }
}
