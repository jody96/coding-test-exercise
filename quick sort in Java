class Main {

  public static void main(String[] args) throws Exception {
    int[] arr = {5,7,9,0,3,1,6,2,4,8};
    quick_sort(arr, 0, arr.length-1);
    for(int i=0; i<arr.length; i++)
      System.out.print(arr[i] + " ");
  }
  public static void quick_sort(int[] array, int start, int end){
    // 원소가 한 개인 경우, return
    if(start >= end)
      return;
    //pivot, left, right 모두 index
    int pivot = start;
    int left = start + 1;
    int right = end;
    while(left <= right){
      //피벗보다 큰 데이터 찾을 때까지
      while((left <= end) && (array[pivot] >= array[left]))
        left++;
       //피벗보다 작은 데이터 찾을 때까지
      while((right > start) && (array[pivot] <= array[right]))
        right--;
      // 엇갈렸으면 작은 데이터와 피벗 교체
      if(left > right){
        swap(array, right, pivot);
      }
      // 엇갈리지 않았다면 작은 데이터와 큰 데이터 교체
      else{
        swap(array, left, right);
      }
    }
    // 분할 이후 왼쪽 부분과 오른쪽 부분에서 재귀적으로 정렬
    quick_sort(array, start, right-1);
    quick_sort(array, right+1, end);
  }
  
  public static void swap(int[] arr, int i, int j){
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

}
