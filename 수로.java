import java.io.*;
import java.util.*;
class Main {
	static int n = 0;
	static int[][] graph;
	static int[][] cnt_graph;
	static int[][] vector = {{-1,0}, {1,0}, {0,1}, {0, -1}};
	static int mod =  (int) 1e9 + 7;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		for(int i=1; i<=n; i++){
			String[] inputs = br.readLine().split(" ");
			for(int j=1; j<=n; j++){
				graph[i][j] = Integer.parseInt(inputs[j-1]);
			}
		}
		cnt_graph = new int[n+1][n+1];
		int ans = dfs(n, n);
		System.out.println(ans);
	}
	private static int dfs(int y, int x){
		if(y == 1 && x == 1)
			return 1;
		if(cnt_graph[y][x] > 0)
			return cnt_graph[y][x];
		int res = 0;
		for(int i=0; i<4; i++){
			int ny = y + vector[i][0];
			int nx = x + vector[i][1];
			
			if(1 <= ny && ny <= n && 1 <= nx && nx <= n){
				if(graph[ny][nx] > graph[y][x]){
					res += dfs(ny, nx) % mod; 
				}
			}
		}
		cnt_graph[y][x] = res;
		return res;
	}
}
