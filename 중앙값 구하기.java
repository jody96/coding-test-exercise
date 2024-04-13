import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");
		int[] int_array = new int[n];
		for(int i=0; i<n; i++){
			int_array[i] = Integer.parseInt(inputs[i]);
		}
		
		PriorityQueue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> min_heap = new PriorityQueue<>();
		
		// 1. max heap size == min heap size 또는 max heap size == min heap size + 1
		// 2. max heap.peek() < min heap.peek()
		
		for(int i=0; i<n; i++){
			int curr = int_array[i];
			
			max_heap.add(curr);
			
			while(!(max_heap.size() == min_heap.size() || max_heap.size() == min_heap.size() + 1)){
				min_heap.add(max_heap.poll());
			}
			
			if(!min_heap.isEmpty()){
				while(max_heap.peek() > min_heap.peek()){
					min_heap.add(max_heap.poll());
					max_heap.add(min_heap.poll());
				}
			}
						
			System.out.println(max_heap.peek());
		}
	}
}
