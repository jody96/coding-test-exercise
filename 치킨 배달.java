import java.util.*;
class Combination {
  private int n;
  private int m;
  private int[] now;
  private ArrayList<ArrayList<Integer>> arr;

  public Combination(int n, int m){
    this.n = n;
    this.m = m;
    this.now = new int[m];
    this.arr = new ArrayList<>();
  }

  public ArrayList<ArrayList<Integer>> getResult(){
    return arr;
  }

  public void combination(int nowIdx, int arrIdx){
    if(nowIdx == m){
      ArrayList<Integer> temp = new ArrayList<>();
      for(int i=0; i<m; i++){
        temp.add(now[i]);
      }
      this.arr.add(temp);
      return;
    }
    if(arrIdx == this.n)
      return;
    combination(nowIdx, arrIdx+1);
    now[nowIdx] = arrIdx;
    combination(nowIdx+1, arrIdx+1); 
  }
}

class Main {
  public static ArrayList<ArrayList<Integer>> home = new ArrayList<>();
  public static ArrayList<ArrayList<Integer>> chicken = new ArrayList<>();
  public static int[][] map;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    map = new int[n][n];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        map[i][j] = sc.nextInt();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(i);
        temp.add(j);
        if(map[i][j] == 1){
          home.add(temp);
        } else if(map[i][j] == 2){
          chicken.add(temp);
        }
      }
    }
    
    Combination comb = new Combination(chicken.size(), m);
    comb.combination(0,0);
    ArrayList<ArrayList<Integer>> result = comb.getResult();
    int answer = (int)1e9;
    for(int i=0; i<result.size(); i++){
      ArrayList<Integer> selected = result.get(i);
      int tmp = 0;
      for(int j=0; j<home.size(); j++){
          int hr = home.get(j).get(0);
          int hc = home.get(j).get(1);
          int min = (int)1e9;
          for(int k=0; k<m; k++){
            int idx = selected.get(k);
            int r = chicken.get(idx).get(0);
            int c = chicken.get(idx).get(1);
            min = Math.min(min, Math.abs(r - hr) + Math.abs(c - hc));
          }
          tmp += min;
      }
      answer = Math.min(answer, tmp);
    }
    System.out.println(answer);
  }
}
