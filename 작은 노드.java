import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int k = Integer.parseInt(inputs[2]);
		
		int[][] graph = new int[n+1][n+1];
		for(int i=0; i<m; i++){
			inputs = br.readLine().split(" ");
			int s = Integer.parseInt(inputs[0]);
			int e = Integer.parseInt(inputs[1]);
			graph[s][e]++;
			graph[e][s]++;
		}
		boolean[] visited = new boolean[n+1];
		visited[k] = true;
	
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(k);
		int visit_num = 1;
		while(!q.isEmpty()){
			int tmp = q.poll();
			int min = (int)1e9;
			for(int i=1; i<=n; i++){
				if(graph[tmp][i] > 0 && !visited[i]){
					min = min < i ? min : i;
				}
			}
			if(min == (int)1e9){
				System.out.println(visit_num + " " + tmp); 
			} else{
				q.offer(min);
				visited[min] = true;	
				visit_num++;
			}
		}
	}
}
