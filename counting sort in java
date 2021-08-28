import java.util.*;
import java.io.*;
class Main {

  public static void main(String[] args) throws Exception {
    int[] arr = {5,7,9,0,3,1,6,2,4,8};
    counting_sort(arr);
    for(int i=0; i<arr.length; i++)
      System.out.print(arr[i] + " ");
  }
  public static void counting_sort(int[] array){
    int max = Integer.MIN_VALUE;
    for(int i=0; i<array.length; i++){
      max = Math.max(max, array[i]);
    }

    int[] count = new int[max+1];
    
    for(int i=0; i<array.length; i++){
      count[array[i]]++;
    }
    int idx = 0;
    for(int i=0; i<count.length; i++){
      for(int j=0; j<count[i]; j++){
        array[idx++] = i; 
      }
    }
  }
}
