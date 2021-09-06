import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int zero = 0;
    int one = 0;
    
    for(int i=1; i<str.length(); i++){
      if(str.charAt(i) != str.charAt(i-1)){
        if(str.charAt(i) == '0'){
          one++;
        } else{
          zero++;
        }
      }
    }
    int result = 0;
    if(one > zero){
      result = zero;
    } else{
      result = one;
    }
    System.out.println(result);
  }
}
