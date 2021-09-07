import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    ArrayList<Character> charArr = new ArrayList<>();
    int num = 0;
    for(int i=0; i<str.length(); i++){
      char c = str.charAt(i);
      if(c>='A' && c<='Z'){
        charArr.add(c);
      }else{
        num += (c - '0');
      }
    }

    Collections.sort(charArr);
    String answer = "";
    for(int i=0; i<charArr.size(); i++){
      answer += (charArr.get(i) + "");
    }
    answer += num;

    System.out.println(answer);
  }
}
