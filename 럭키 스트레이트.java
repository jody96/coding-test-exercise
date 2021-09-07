import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String num = sc.next();
    int forward = 0;
    int back = 0;
    for(int i=0; i<num.length()/2; i++){
      forward += (num.charAt(i) - '0');
    }
    for(int i=num.length()/2; i<num.length(); i++){
      back += (num.charAt(i) - '0');
    }

    if(forward == back)
      System.out.println("LUCKY");
    else
      System.out.println("READY");
  }
}
