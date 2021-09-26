import java.util.*;

class Student implements Comparable<Student>{
  private String name;
  private int korean;
  private int english;
  private int math;

  public Student(String name, int korean, int english, int math){
    this.name = name;
    this.korean = korean;
    this.english = english;
    this.math = math;
  }

  public String getName(){
    return name;
  }
  
  @Override
  public int compareTo(Student other){
    if(this.korean == other.korean){
      if(this.english == other.english){
        if(this.math == other.math){
          return this.name.compareTo(other.name);
        }
        return Integer.compare(other.math,this.math);
      }
      return Integer.compare(this.english, other.english);
    }
    return Integer.compare(other.korean, this.korean);
  }
}
class Main {
  public static int n;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> arr = new ArrayList<>();
    n = sc.nextInt();
    for(int i=0; i<n; i++){
      String name = sc.next();
      int kor = sc.nextInt();
      int eng = sc.nextInt();
      int math = sc.nextInt();
      arr.add(new Student(name, kor, eng, math));
    }
    Collections.sort(arr);
    for(int i=0; i<arr.size(); i++){
      System.out.println(arr.get(i).getName());
    }
  }
}
